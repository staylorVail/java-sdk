package com.vailsys.persephony.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicLogWriterTest {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private BasicLogWriter writer;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Entry e;

    @Given("^a log writer with level (.*) and a log entry with level (.*)$")
    public void create(String writerLevelString, String entryLevelString){
        Level writerLevel = Level.valueOf(writerLevelString);
        Level entryLevel = Level.valueOf(entryLevelString);

        writer = new BasicLogWriter();
        writer.setLevel(writerLevel);
        HashMap<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        Date timestamp = new Date();
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        e = mock(Entry.class);
        when(e.getLevel()).thenReturn(entryLevel);
        when(e.getMessage()).thenReturn("testing message");
        when(e.getMetadata()).thenReturn(metadata);
        when(e.getTimestamp()).thenReturn(timestamp);
        when(e.getTrace()).thenReturn(trace);
    }

    @When("^the BasicLogWriter write is called$")
    public void write(){
        PrintStream outputStream = new PrintStream(output);
        System.setOut(outputStream);

        writer.write(e);
    }

    @Then("^the BasicLogWriter should output the text to stdout$")
    public void check(){
        String text = output.toString();

        assertTrue(text.contains(String.format("[%s] %s - testing message", e.getLevel().name(), e.getTimestamp())));
        assertTrue(text.contains(gson.toJson(e.getMetadata())));
        assertTrue(text.contains(e.getTrace()[0].toString()));
        assertTrue(text.contains(e.getTrace()[1].toString()));
    }

    @Then("^the BasicLogWriter should not output the text to stdout$")
    public void invertCheck(){
        String text = output.toString();
        assertEquals("", text);

    }
}
