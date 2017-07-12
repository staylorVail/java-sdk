package com.vailsys.persephony.api.conference;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when
 * creating a Conference.
 *
 * @see com.vailsys.persephony.api.conference.ConferencesRequester#create(ConferenceCreateOptions)
 */
public class ConferenceCreateOptions extends CommonFields {
	/**
	 * The alias allows the conference to be referred to by a user defined name rather than a Persephony generated Id.
	 */
	private String alias;
	/**
	 * Whether or not to play tones when calls enter or exit the conference.
	 *
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	private PlayBeep playBeep;
	/**
	 * Whether or not to record this conference call.
	 */
	private Boolean record;
	/**
	 * The url to send updates to when the conference changes states.
	 */
	private String statusCallbackUrl;
	/**
	 * The url Persephony checks for a PerCL script to perform against calls waiting for the conference to start.
	 */
	private String waitUrl;

	/**
	 * Retrieve the alias of the create options.
	 *
	 * @return The alias of the conference to be created.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Retrieve the playBeep setting of the create option.
	 *
	 * @return The playBeep setting of the conference to be created.
	 *
	 * @see com.vailsys.persephony.api.conference.PlayBeep
	 */
	public PlayBeep getPlayBeep() {
		return this.playBeep;
	}

	/**
	 * Retrieve the record setting of the create option.
	 *
	 * @return The record setting of the conference to be created.
	 */
	public Boolean getRecord() {
		return this.record;
	}

	/**
	 * Retrieve the status callback url of the create option.
	 *
	 * @return The status callback url of the conference to be created.
	 */
	public String getStatusCallbackUrl() {
		return this.statusCallbackUrl;
	}

	/**
	 * Retrieve the wait url of the create option.
	 *
	 * @return The wait url of the conference to be created.
	 */
	public String getWaitUrl() {
		return this.waitUrl;
	}

	/**
	 * Set the alias create option to give the new conference an alias.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Set the playBeep create option to set the new conference's playBeep property.
	 */
	public void setPlayBeep(PlayBeep playBeep) {
		this.playBeep = playBeep;
	}

	/**
	 * Set the record create option to set the new conference's record property.
	 */
	public void setRecord(Boolean record) {
		this.record = record;
	}

	/**
	 * Set the statusCallbackUrl create option to set the new conference's statusCallbackUrl property.
	 */
	public void setStatusCallbackUrl(String statusCallbackUrl) {
		this.statusCallbackUrl = statusCallbackUrl;
	}

	/**
	 * Set the waitUrl create option to set the new conference's waitUrl property.
	 */
	public void setWaitUrl(String waitUrl) {
		this.waitUrl = waitUrl;
	}
}
