package com.vailsys.persephony.log;

public class NopLogWriter implements LogWriter {
  public void setLevel(Level l){}
  public void write(Entry e){}
}
