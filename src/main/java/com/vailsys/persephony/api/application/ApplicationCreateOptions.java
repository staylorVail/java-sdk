package com.vailsys.persephony.api.application;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when creating an Application.
 */
public class ApplicationCreateOptions extends CommonFields {

    /**
     * The alias allows the application to be referred to by a user defined name rather than a Persephony generated Id.
     */
    private String alias;
    /**
     * The url that will be requested when an inbound call is received.
     */
    private String voiceUrl;
    /**
     * The url that will be requested in the case of an error requesting or executing the voiceUrl PerCL script.
     */
    private String voiceFallbackUrl;
    /**
     * The url to send the result of an outbound call
     */
    private String callConnectUrl;
    /**
     * The url to request when the call ends
     */
    private String statusCallbackUrl;

    /**
     * Retrieve the alias of the create options.
     *
     * @return The alias of the application to be created.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the alias create option to give the new application an alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the voiceUrl of the create option.
     *
     * @return The voiceUrl of the application to be created.
     */
    public String getVoiceUrl() {
        return voiceUrl;
    }

    /**
     * Set the voiceUrl create option to set the new application's voiceUrl property
     */
    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    /**
     * Retrieve the voiceFallbackUrl of the create option.
     *
     * @return The voiceFallbackUrl of the application to be created.
     */
    public String getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    /**
     * Set the voiceFallbackUrl create option to set the new application's voiceFallbackUrl property.
     */
    public void setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
    }

    /**
     * Retrieve the callConnectUrl of the create option.
     *
     * @return The callConnectUrl of the application to be created.
     */
    public String getCallConnectUrl() {
        return callConnectUrl;
    }

    /**
     * Set the callConnectUrl create option to set the new application's callConnectUrl property.
     */
    public void setCallConnectUrl(String callConnectUrl) {
        this.callConnectUrl = callConnectUrl;
    }

    /**
     * Retreive the statusCallbackUrl of the create option.
     *
     * @return The statusCallbackUrl of the application to be created.
     */
    public String getStatusCallbackUrl() {
        return statusCallbackUrl;
    }

    /**
     * Set the statusCallbackUrl create option to set the new application's statusCallbackUrl property.
     */
    public void setStatusCallbackUrl(String statusCallbackUrl) {
        this.statusCallbackUrl = statusCallbackUrl;
    }
}
