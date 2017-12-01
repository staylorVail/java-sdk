package com.vailsys.persephony.log;

/**
 * Created by staylor on 11/28/17.
 *
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
