package com.vailsys.persephony.api.phoneNumber;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyJSONException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents a Persephony AvailablePhoneNumber instance. AvailablePhoneNumber objects are created by the SDK whenever an availablephonenumber instance would be returned by the API; these primarily come from a {@link com.vailsys.persephony.api.phoneNumber.AvailablePhoneNumberRequester} inside a {@link com.vailsys.persephony.api.PersyClient} instance.<br />
 * <br />
 * AvailablePhoneNumbers are immutable and intended only to be used to read information returned from the API in a language accessible way.
 *
 * @see com.vailsys.persephony.api.phoneNumber.AvailablePhoneNumberRequester
 * @see com.vailsys.persephony.api.PersyClient
 */
public class AvailablePhoneNumber extends PhoneNumber {
    /**
     * The voiceEnabled setting for this phone number.
     */
    private boolean voiceEnabled;
    /**
     * The region of this phone number.
     */
    private String region;
    /**
     * The country of this phone number.
     */
    private String country;

    /**
     * Converts the provided JSON string into an AvailablePhoneNumber object.
     *
     * @param json A JSON string representing an AvailablePhoneNumber instance.
     * @return An AvailablePhoneNumber object equivalent to the JSON string passed in.
     */
    public static AvailablePhoneNumber fromJson (String json) throws PersyJSONException {
        try {
            return gson.fromJson(json, AvailablePhoneNumber.class);
        }
        catch(JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }
    }

    /**
     * Retrieve the voiceEnabled setting from the object.
     *
     * @return The voiceEnabled for this AvailablePhoneNumber.
     */
    public boolean isVoiceEnabled() {
        return voiceEnabled;
    }

    /**
     * Retrieve the region of the phone number.
     *
     * @return The region of this AvailablePhoneNumber.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Retrieve the country of the phone number.
     *
     * @return The country of this AvailablePhoneNumber.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Check if this AvailablePhoneNumber equals another. This is done by comparing all fields in the AvailablePhoneNumber for equality.
     *
     * @param that The AvailablePhoneNumber object for comparison.
     * @return {@code true} if available phone numbers are equals, {@code false} otherwise.
     */
    public boolean equals(AvailablePhoneNumber that){
        boolean result = super.equals(that);
        result = result && (this.isVoiceEnabled() == that.isVoiceEnabled());
        if(this.getRegion() != null){
            result = result && that.getRegion().equals(this.getRegion());
        } else {
            result = result && that.getRegion() == null;
        }

        if(this.getCountry() != null){
            result = result && that.getCountry().equals(this.getCountry());
        } else {
            result = result && that.getCountry() == null;
        }

        return result;
    }
}
