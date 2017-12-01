package com.vailsys.persephony.log;

public interface LogWriter {
    public void setLevel(Level l);
    public void write(Entry e);
}
