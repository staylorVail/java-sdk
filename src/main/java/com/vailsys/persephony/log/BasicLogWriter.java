package com.vailsys.persephony.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicLogWriter implements LogWriter {
    private Level level = Level.ERROR;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void setLevel(Level l) {
        this.level = l;
    }

    public void write(Entry e){
        if (e.getLevel().ordinal() >= this.level.ordinal()) {
            System.out.println(String.format("[%s] %s - %s", e.getLevel(), e.getTimestamp(), e.getMessage()));
            if(e.getMetadata() != null && e.getMetadata().size() > 0) {
                System.out.println(gson.toJson(e.getMetadata()));
            }
            if(e.getTrace() != null && e.getTrace().length > 0) {
                System.out.println(e.getTrace()[0]);
                for (int i = 1; i < e.getTrace().length; i++) {
                    System.out.println("at " + e.getTrace()[i]);
                }
            }
        }
    }
}
