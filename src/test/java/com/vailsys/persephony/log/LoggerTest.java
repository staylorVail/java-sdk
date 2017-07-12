package com.vailsys.persephony.log;

import cucumber.api.java.en.When;
import org.mockito.ArgumentCaptor;

import java.util.HashMap;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoggerTest {

    @When("^the Logger logs an entry it should call the writer's write method with the entry$")
    public void checklog(){
        BasicLogWriter writer = mock(BasicLogWriter.class);
        Logger.setWriter(writer);
        Entry entry = mock(Entry.class);

        Logger.log(entry);

        verify(writer).write(entry);
    }

    @When("^the logger logs with all the components of an entry it should call the writer's write method with an entry matching the arguments$")
    public void checkLogFromComponents(){
        ArgumentCaptor<Entry> captor = ArgumentCaptor.forClass(Entry.class);
        BasicLogWriter writer = mock(BasicLogWriter.class);
        Logger.setWriter(writer);
        Level level = Level.INFO;
        String message = "message";
        HashMap<String, Object> metadata = new HashMap<>();
        StackTraceElement[] trace = new StackTraceElement[0];

        Logger.log(level, message, metadata, trace);

        verify(writer).write(captor.capture());
        Entry calledEntry = captor.getValue();
        assertThat(calledEntry.getLevel(), is(Level.INFO));
        assertThat(calledEntry.getMessage(), is(message));
        assertThat(calledEntry.getMetadata(), is(metadata));
        assertThat(calledEntry.getTrace(), is(trace));
    }

    @When("^the logger writes an? (?:.*) log the level should be (.*)")
    public void checkLevel(String level){
        ArgumentCaptor<Entry> captor = ArgumentCaptor.forClass(Entry.class);
        BasicLogWriter writer = mock(BasicLogWriter.class);
        Logger.setWriter(writer);
        String message = "message";
        HashMap<String, Object> metadata = new HashMap<>();
        StackTraceElement[] trace = new StackTraceElement[0];

        switch (level){
            case "debug":Logger.debug(message, metadata, trace); break;
            case "info": Logger.info(message, metadata, trace); break;
            case "warn": Logger.warn(message, metadata, trace); break;
            case "error": Logger.error(message,metadata, trace); break;
            default: fail("Level " + level + " unknown");
        }

        verify(writer).write(captor.capture());
        Entry passedEntry = captor.getValue();
        assertThat(passedEntry.getLevel(), is(Level.valueOf(level.toUpperCase())));
        assertThat(passedEntry.getMessage(), is(message));
        assertThat(passedEntry.getMetadata(), is(metadata));
        assertThat(passedEntry.getTrace(), is(trace));
    }
}
