package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyList;

/**
 * Represents a paginated list of Persephony IncomingPhonenumber instances. This object will be automatically created by a {@link com.vailsys.persephony.api.phoneNumber.IncomingPhoneNumberRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance and its creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.persephony.api.PersyList
 */
public class IncomingPhoneNumberList extends PersyList<IncomingPhoneNumber> {
    /**
     * Creates a new IncomingPhoneNumberList.
     *
     * @param credAccountId the accountId to use in requests for subsequent pages.
     * @param credAuthToken the authToken to use in requests for subsequent pages.
     * @param rawPage the raw JSON string representing a page of a conference list from the Persephony API.
     */
    public IncomingPhoneNumberList(String credAccountId, String credAuthToken, String rawPage) throws PersyException {
        super(credAccountId, credAuthToken, rawPage, "incomingPhoneNumbers", IncomingPhoneNumber.class);
    }
}
