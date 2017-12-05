package com.vailsys.persephony.log;

/**
 * This class is used to test the APIRequester.
 * The implmentation of the interface methods do not matter since
 * the tests only assert the methods were called with the given arguments.
 */
public class TestLogWriter implements LogWriter {
    public void setLevel(Level level) {
        return;
    }

    public void write(Entry e) { return; }
}
