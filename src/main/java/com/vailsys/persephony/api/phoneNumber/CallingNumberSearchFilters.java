package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for calling numbers.
 */
public class CallingNumberSearchFilters extends Filters {
    /**
     * The phone number of the calling number.
     */
    private String phoneNumber;
    /**
     * The alias of the calling number.
     */
    private String alias;

    /**
     * Retrieve the value of the phone number filter.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number filter for calling numbers that match the phone number.
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
     * Set the alias filter for calling numbers that match the alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
