package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.PersyJSONException;
import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;

/**
 *	A PersyRequest represents the JSON object that is sent to the webhooks
 *	(voiceUrl, voiceFallbackUrl, etc.) of Persephony applications. All webhooks
 *	except the statusCallbackUrl will receive a payload in this form.
 */
public class PersyRequest {

	/**
	 * Helper method to build a PersyRequest object from the JSON string sent
	 * to your application by Persephony
	 */
	public static PersyRequest fromJson(String rawJson) throws PersyJSONException {
		try {
			return gson.fromJson(rawJson, PersyRequest.class);
		}
		catch(JsonIOException jioe) {
			throw new PersyJSONException(jioe);
		}
		catch(JsonSyntaxException jse) {
			throw new PersyJSONException(jse);
		}
	}

	private String accountId;
	private String callId;
	private CallStatus callStatus;
	private String conferenceId;
	private Direction direction;
	private String from;
	private String queueId;
	private String requestId;
	private String requestType;
	private String to;

	public String getAccountId(){
		return this.accountId;
	}
	public String getCallId(){
		return this.callId;
	}
	public CallStatus getCallStatus(){
		return this.callStatus;
	}
	public String getConferenceId(){
		return this.conferenceId;
	}
	public Direction getDirection(){
		return this.direction;
	}
	public String getFrom(){
		return this.from;
	}
	public String getQueueId(){
		return this.queueId;
	}
	public String getRequestId(){
		return this.requestId;
	}
	public String getRequestType(){
		return this.requestType;
	}
	public String getTo(){
		return this.to;
	}
}
