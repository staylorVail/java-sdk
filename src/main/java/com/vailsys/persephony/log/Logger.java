package com.vailsys.persephony.log;

import java.util.HashMap;

public class Logger {
    private static Level level = Level.ERROR;
    private static LogWriter w = new NopLogWriter();

    public static void setLevel(Level l){
        level = l;
    }

    public static void setWriter(LogWriter writer){
        w = writer;
    }


    public static void log(Entry e){
        w.write(e);
    }

    public static void log(Level level, String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        w.write(new Entry(level, message, metadata, trace));
    }

    public static void debug(String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        w.write(new Entry(Level.DEBUG, message, metadata, trace));
    }

    public static void info(String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        w.write(new Entry(Level.INFO, message, metadata, trace));
    }

    public static void warn(String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        w.write(new Entry(Level.WARN, message, metadata, trace));
    }

    public static void error(String message, HashMap<String, Object> metadata, StackTraceElement[] trace){
        w.write(new Entry(Level.ERROR, message, metadata, trace));
    }


}