package com.vailsys.persephony.api.application;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ApplicationCreateOptionsTest {
    private ApplicationCreateOptions options;

    @Given("^an empty ApplicationCreateOptions object")
    public void createApplicationCreateOptions() { this.options = new ApplicationCreateOptions(); }

    @Then("^check that all ApplicationCreateOptions fields are null$")
    public void checkFieldsAreNull(){
        assertThat(this.options.getAlias(), nullValue());
        assertThat(this.options.getVoiceUrl(), nullValue());
        assertThat(this.options.getVoiceFallbackUrl(), nullValue());
        assertThat(this.options.getCallConnectUrl(), nullValue());
        assertThat(this.options.getStatusCallbackUrl(), nullValue());
    }

    @Then("^set (alias|voiceUrl|voiceFallbackUrl|callConnectUrl|statusCallbackUrl) to (.*) in ApplicationCreateOptions$")
    public void setField(String field, String value){
        if(field.equals("alias")){
            this.options.setAlias(value);
        }
        if(field.equals("voiceUrl")){
            this.options.setVoiceUrl(value);
        }
        if(field.equals("voiceFallbackUrl")){
            this.options.setVoiceFallbackUrl(value);
        }
        if(field.equals("callConnectUrl")){
            this.options.setCallConnectUrl(value);
        }
        if(field.equals("statusCallbackUrl")){
            this.options.setStatusCallbackUrl(value);
        }

    }

    @Then("^check that (alias|voiceUrl|voiceFallbackUrl|callConnectUrl|statusCallbackUrl) is (.*) in ApplicationCreateOptions$")
    public void checkField(String field, String value){
        if(field.equals("alias")){
            assertThat(this.options.getAlias(), is(value));
        }
        if(field.equals("voiceUrl")){
            assertThat(this.options.getVoiceUrl(), is(value));
        }
        if(field.equals("voiceFallbackUrl")){
            assertThat(this.options.getVoiceFallbackUrl(), is(value));
        }
        if(field.equals("callConnectUrl")){
            assertThat(this.options.getCallConnectUrl(), is(value));
        }
        if(field.equals("statusCallbackUrl"))
        {
            assertThat(this.options.getStatusCallbackUrl(), is(value));
        }
    }
}
