package com.vailsys.persephony.api.phoneNumber;

import com.vailsys.persephony.api.Filters;

/**
 * Represents the possible fields one can set as filters when searching for available phone numbers.
 */
public class AvailablePhoneNumberSearchFilters extends Filters {
    /**
     * The alias of the phone number.
     */
    private String alias;
    /**
     * A regular expression to filter the phone numbers available.
     */
    private String phoneNumber;

    /**
     * Retrieve the value of the alias filter.
     *
     * @return The alias of the filter.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias filter for available phone numbers that match the alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the value of the phoneNumber filter.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phoneNumber filter for available phone numbers that match the expression.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
