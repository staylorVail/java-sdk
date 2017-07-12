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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicLogWriterTest {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private BasicLogWriter writer;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Entry e;

    @Given("^a BasicLogWriter object$")
    public void create(){
        writer = new BasicLogWriter();
        HashMap<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");
        Date timestamp = new Date();
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        e = mock(Entry.class);
        when(e.getLevel()).thenReturn(Level.DEBUG);
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

    @Then("^the BasicLogWriter should output the correct text to stdout$")
    public void check(){
        String text = output.toString();

        assertTrue(text.contains(String.format("[DEBUG] %s - testing message", e.getTimestamp())));
        assertTrue(text.contains(gson.toJson(e.getMetadata())));
        assertTrue(text.contains(e.getTrace()[0].toString()));
        assertTrue(text.contains(e.getTrace()[1].toString()));
    }
}
