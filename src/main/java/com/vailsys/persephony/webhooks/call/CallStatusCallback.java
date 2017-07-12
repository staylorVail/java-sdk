package com.vailsys.persephony.webhooks.call;

import com.vailsys.persephony.webhooks.StatusCallback;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.AnsweredBy;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

public class CallStatusCallback extends StatusCallback {
	private CallStatus dialCallStatus;
	private AnsweredBy answeredBy;

	private CallStatusCallback(){}

	public static CallStatusCallback createFromJson(String jsonString) throws PersyException {
		try {
			return gson.fromJson(jsonString, CallStatusCallback.class);
		}
		catch(JsonIOException jioe) {
			throw new PersyJSONException(jioe);
		}
		catch(JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}
	}

	public CallStatus getDialCallStatus() {
		return this.dialCallStatus;
	}
	public AnsweredBy getAnsweredBy() {
		return this.answeredBy;
	}

}
