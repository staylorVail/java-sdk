package com.vailsys.persephony.log;

import java.util.Date;
import java.util.HashMap;

public class Entry {
    private Level level;
    private Date timestamp;
    private String message;
    private HashMap<String, Object> metadata;
    private StackTraceElement[] trace;

    public Entry(Level level, String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        this.level = level;
        this.timestamp = new Date();
        this.message = message;
        this.metadata = metadata;
        this.trace = trace;
    }

    public Level getLevel() {
        return level;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, Object> getMetadata() {
        return metadata;
    }

    public StackTraceElement[] getTrace() {
        return trace;
    }
}
