package com.vailsys.persephony.log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;

public class EntryTest {
    private Entry e;
    private HashMap<String, Object> metadata;
    private StackTraceElement[] trace;
    private Date timestamp = null;

    @Given("^an Entry object$")
    public void createEntry(){
        trace = Thread.currentThread().getStackTrace();
        metadata = new HashMap<>();
        metadata.put("key", 2);
        timestamp = new Date();
        e = new Entry(Level.ERROR, "Test Message", metadata, trace);
    }

    @Then("^verify the Entry's contents$")
    public void verifyContents(){
        assertThat(e.getLevel(), is(Level.ERROR));
        assertThat(e.getMessage(), is("Test Message"));
        assertTrue(e.getMetadata().get("key") == metadata.get("key"));
        assertThat(e.getTrace(), is(trace));
        assertThat(e.getTimestamp(), is(timestamp));
    }



}
