package com.vailsys.persephony.api.recording;

import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.text.FieldPosition;

import com.vailsys.persephony.api.APIRequester;
import com.vailsys.persephony.api.Filters;
import com.vailsys.persephony.api.PersySDKException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyDateException;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.reflect.TypeToken;

public class RecordingsSearchFilters extends Filters {
	private String callId;
	private String dateCreated;

	public String getCallId() {
		return this.callId;	
	}

	public String getDateCreated() {
		return this.dateCreated;	
	}

	public Date getDateCreatedAsDate() throws PersyException {
		ParsePosition pos = new ParsePosition(0);

		Date dc;
		try {
			dc = dateCreatedFormat.parse(this.dateCreated, pos);
			if(pos.getErrorIndex() >= 0) {
				throw new PersyDateException(this.dateCreated, pos.getErrorIndex());
			}
		} catch(NullPointerException npe) {
			if(pos == null) {
				throw new PersySDKException(npe);
			} else {
				throw new PersyException("dateCreated field in RecordingsRequestFilters was null", npe);
			}
		}
		return dc;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		StringBuffer sb = new StringBuffer(dateCreatedFormatString.length());
		FieldPosition fp = new FieldPosition(0);

		StringBuffer dateCreatedBuffer = dateCreatedFormat.format(dateCreated, sb, fp);
		
		this.dateCreated = dateCreatedBuffer.toString();
	}
}
