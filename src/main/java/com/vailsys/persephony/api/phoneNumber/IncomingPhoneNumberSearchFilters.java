package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for incoming phone numbers.
 */
public class IncomingPhoneNumberSearchFilters extends Filters {
    /**
     * A PCRE compatible regular expression to match against the phone numbers of the incoming phone number list.
     *
     */
    private String phoneNumber;
    /**
     * The alias of the incoming phone number.
     */
    private String alias;

    /**
     * Retrieve the value of the phone number filter.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number filter for incoming phone numbers.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieve the value of the alias filter.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias filter for incoming phone numbers.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
