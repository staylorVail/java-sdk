package com.vailsys.persephony.api.conference;

import com.vailsys.persephony.api.PersyList;
import com.vailsys.persephony.api.PersyException;

/**
 * Represents a paginated list of Persephony Conference instances. This object will
 * be automatically created by a 
 * {@link com.vailsys.persephony.api.conference.ConferencesRequester} inside a 
 * {@link com.vailsys.persephony.api.PersyClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class ConferenceList extends PersyList<Conference> {

	/**
	 * Creates a new ConferenceList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param authToken the authToken to use in requests for subsequent pages.
	 * @param rawPage the raw JSON string representing a page of a conference list from the Persephony API.
	 */
	public ConferenceList(String accountId, String authToken, String rawPage) throws PersyException {
		super(accountId, authToken, rawPage, "conferences", Conference.class);
	}
}
