package com.vailsys.persephony.api.recording;

import java.io.*;
import java.util.HashMap;
import java.util.Date;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import com.vailsys.persephony.KnownSizeInputStream;
import com.vailsys.persephony.api.APIAccountRequester;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersySDKException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.PersyJSONException;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class RecordingsRequester extends APIAccountRequester {
	private static final String pathHead = "Recordings";
	private static final String downloadSuffix = "Download";
	private static final String streamSuffix = "Stream";
	private final String path;
	private final String actingAccountId;

	public RecordingsRequester(String credAccountId, String credAuthToken, String actingAccountId) throws PersyException {
		super(credAccountId, credAuthToken); 
		this.actingAccountId = actingAccountId;
		this.path = APIAccountRequester.constructPath(APIAccountRequester.rootPath,this.actingAccountId, pathHead);
	}

	public String getActingAccountId() {
		return this.actingAccountId;
	}

	public String getPath() {
		return this.path;
	}

	private String getRecordingPath(String recordingId) { 
		return APIAccountRequester.constructPath(this.path, recordingId);
	}

	private String getDownloadPath(String recordingId) {
		return APIAccountRequester.constructPath(this.getRecordingPath(recordingId), downloadSuffix);
	}

	private String getStreamPath(String recordingId) {
		return APIAccountRequester.constructPath(this.getRecordingPath(recordingId), streamSuffix);
	}


	/**
	 * Allows SDK developers to change which instance of the Persephony API that the RecordingsRequester points to.
	 *
	 * @param newUrl The new URL to use in place of the default APIAccountRequester.PERSY_URL
	 */
	protected void setPersyUrl(String newUrl) {
		super.setPersyUrl(newUrl);
	}

	public RecordingList getMeta() throws PersyException {
		return new RecordingList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.path));
	}

	public RecordingList getMeta(RecordingsSearchFilters filters) throws PersyException { 
		HashMap<String,String> filtersMap;

		try {
			filtersMap = gson.fromJson(gson.toJson(filters), APIAccountRequester.GETMapType);
		} catch (JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}

		return new RecordingList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.path, filtersMap));
	}

	public Recording getMetaByRecordingId(String recordingId) throws PersyException {
		return Recording.fromJson(this.GET(this.getRecordingPath(recordingId)));
	}

	public Integer download(String recordingId, String fileName) throws PersyException, IOException  {
		return this.download(recordingId, Paths.get(fileName));
	}

	public Integer download(String recordingId, File file) throws PersyException, IOException  {
		return this.download(recordingId, file.toPath());
	}

	public Integer download(String recordingId, Path path) throws PersyException, IOException {
		KnownSizeInputStream ksis = this.GETStream(this.getDownloadPath(recordingId));
		BufferedInputStream bis = new BufferedInputStream(ksis);
		Files.copy(bis, path, REPLACE_EXISTING);
		return ksis.size();
	}

	public byte[] download(String recordingId) throws PersyException {
		KnownSizeInputStream ksis = this.GETStream(this.getDownloadPath(recordingId));
		Integer length = ksis.size();
		byte[] resultArray = new byte[length];
		DataInputStream dis = new DataInputStream(ksis);

		try {
			dis.readFully(resultArray);
		} catch (IOException ioe) {
			throw new PersyException("Failed to read server response into byte array.", ioe);
		}

		return resultArray;
	}

	public KnownSizeInputStream stream(String recordingId) throws PersyException {
		return this.GETStream(this.getStreamPath(recordingId));
	}

	public void delete(String recordingId) throws PersyException {
		this.DELETE(this.path+"/"+recordingId);
	}
}
