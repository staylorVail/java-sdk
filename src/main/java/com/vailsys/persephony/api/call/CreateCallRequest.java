package com.vailsys.persephony.api.call;

import static com.vailsys.persephony.json.PersyGson.gson;

import com.google.gson.JsonIOException;

/**
 * Represents the fields needed to create a new call on Persephony.
 *
 * @see com.vailsys.persephony.api.call.CallsRequester
 */
class CreateCallRequest {
	public String to;
	public String from;

	public String applicationId;

	public String callConnectUrl;
	public String statusCallbackUrl;

	public String sendDigits;
	public IfMachine ifMachine;
	public Integer timeout;

	/**
	 * Setup a new call creation payload using an applicationId.
	 *
	 * @param to The number to call out to (DNIS). This can be any valid phone
	 * number formatted in E.164 format.
	 * @param from The number to call from (ANI). This must be a number
	 * purchase from Persephony or a verified phone number owned by the user.
	 * @param applicationId The {@code applicationId} for the registered
	 * Persephony application which should handle this call.
	 * @param callOptions Optional arguments that can be provided when creating
	 * a call. See Persephony documentation for details.
	 */
	public CreateCallRequest(String to, String from, String applicationId, CallOptions options) {
		this(to, from, null, null, applicationId, options);
	}

	/**
	 * Setup a new call creation payload using an raw URLs.
	 *
	 * @param to The number to call out to (DNIS). This can be any valid phone
	 * number formatted in E.164 format.
	 * @param from The number to call from (ANI). This must be a number
	 * purchase from Persephony or a verified phone number owned by the user.
	 * @param callConnectUrl Like with a registered Persephony application,
	 * this is the URL that Persephony makes requests to when the call
	 * connects. See the {@code callConnectUrl} in the Persephony Application
	 * documentation.
	 * @param statusCallbackUrl The URL to which Persephony will report call
	 * status notifications. See the {@code statusCallbackUrl} in the
	 * Persephony Application documentation.
	 * @param callOptions Optional arguments that can be provided when creating
	 * a call. See Persephony documentation for details.
	 */
	public CreateCallRequest(String to, String from, String callConnectUrl, String statusCallbackUrl, CallOptions options) {
		this(to, from, callConnectUrl, statusCallbackUrl, null, options);
	}

	/**
	 * Setup a new call creation payload. This is a catch all constructor that
	 * exists to reduce code duplication but should never be used outside the
	 * overloaded constructors for this class.
	 *
	 * @param to The number to call out to (DNIS). This can be any valid phone
	 * number formatted in E.164 format.
	 * @param from The number to call from (ANI). This must be a number
	 * purchase from Persephony or a verified phone number owned by the user.
	 * @param applicationId The {@code applicationId} for the registered
	 * Persephony application which should handle this call.
	 * @param callConnectUrl Like with a registered Persephony application,
	 * this is the URL that Persephony makes requests to when the call
	 * connects. See the {@code callConnectUrl} in the Persephony Application
	 * documentation.
	 * @param statusCallbackUrl The URL to which Persephony will report call
	 * status notifications. See the {@code statusCallbackUrl} in the
	 * Persephony Application documentation.
	 * @param callOptions Optional arguments that can be provided when creating
	 * a call. See Persephony documentation for details.
	 */
	private CreateCallRequest(String to, String from, String callConnectUrl, String statusCallbackUrl, String applicationId, CallOptions options) {
		this.to = to;
		this.from = from;

		this.applicationId = applicationId;

		this.callConnectUrl = callConnectUrl;
		this.statusCallbackUrl = statusCallbackUrl;

		if(options != null) {
			this.sendDigits = options.getSendDigits();
			this.ifMachine = options.getIfMachine();
			this.timeout = options.getTimeout();
		}
	}

	/**
	 * Convert this object into a JSON payload to use in Persephony call creation requests.
	 *
	 * @return JSON representation of this object.
	 */
	public String toJson() throws JsonIOException {
		return gson.toJson(this);
	}
}
