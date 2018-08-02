package com.creditsuisse.assignment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServerLog {

    private String id;
    private String state;
    private long timestamp;
    private String host;
    private String type;
    private LocalDateTime logInputDate;
    private boolean alertFlag;
    private int processedTime;

    public ServerLog(String id, String state, long timestamp, String host, String type) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.host = host;
        this.type = type;
        this.logInputDate = convertMillisecondsIntoDate(this.getTimestamp());
        this.alertFlag = false;
        this.processedTime = 0;
    }

    public void setAlertFlag(boolean alertFlag) {
        this.alertFlag = alertFlag;
    }

    public LocalDateTime convertMillisecondsIntoDate(long timeInMilliseconds) {
        Instant inst  = Instant.ofEpochMilli(timeInMilliseconds);
        return LocalDateTime.ofInstant(inst,ZoneId.of("CET"));
    }
    @Override
    public String toString() {
        return "PROCESS_ID: " + this.id + "\nSTATE: " + this.state + "\nTIME_STAMP: " + this.timestamp
                + "\nHOST: " + this.host + "\nTYPE: " + this.type + "\nPROCESS_CREATION: " + this.getLogInputDate()
                + "\nALERT_FLAG: " + this.isAlertFlag() + "\nTIME_PROCESSED: " + this.processedTime +" ms";
    }

    public LocalDateTime getLogInputDate() {
        return logInputDate;
    }

    public boolean isAlertFlag() {
        return alertFlag;
    }

    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public int getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(int processedTime) {
        this.processedTime = processedTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public void setHost(String host) {
        this.host = host;
    }
    public void setType(String type) {
        this.type = type;
    }
}
