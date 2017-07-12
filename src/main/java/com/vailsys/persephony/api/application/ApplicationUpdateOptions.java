package com.vailsys.persephony.api.application;

import com.vailsys.persephony.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when
 * updating an Application.
 */
public class ApplicationUpdateOptions extends CommonFields {
    /**
     * The alias of the application.
     */
    private String alias;
    /**
     *  The url that will be requested when an inbound call is received.
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
     * Retrieve the alias of the update options.
     *
     * @return The alias of the application to be updated.
     */
    public String getAlias() {
        return alias;
    }

    /**
     *  Set the alias update option to set the alias of the application.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the voiceUrl of the update options.
     *
     * @return The voiceUrl of the application to be updated.
     */
    public String getVoiceUrl() {
        return voiceUrl;
    }

    /**
     * Set the voiceUrl update option to set the voiceUrl of the application.
     */
    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    /**
     * Retrieve the voiceFallbackUrl of the update options.
     *
     * @return The voiceFallbackUrl of the application to be updated.
     */
    public String getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    /**
     * Set the voiceFallbackUrl update option to set the voiceFallbackUrl of the application.
     */
    public void setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
    }

    /**
     * Retrieve the callConnectUrl of the update options.
     *
     * @return The callConnectUrl of the application to be updated.
     */
    public String getCallConnectUrl() {
        return callConnectUrl;
    }

    /**
     * Set the callConnectUrl update option to set the callConnectUrl of the application.
     */
    public void setCallConnectUrl(String callConnectUrl) {
        this.callConnectUrl = callConnectUrl;
    }

    /**
     * Retrieve the statusCallbackUrl of the update options.
     *
     * @return The statusCallbackUrl of the application to be updated.
     */
    public String getStatusCallbackUrl() {
        return statusCallbackUrl;
    }

    /**
     * Set the statusCallbackUrl update option to set the statusCallbackUrl of the application.
     */
    public void setStatusCallbackUrl(String statusCallbackUrl) {
        this.statusCallbackUrl = statusCallbackUrl;
    }
}
