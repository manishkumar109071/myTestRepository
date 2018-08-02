package com.creditsuisse.assignment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServerLog implements Comparable {

    private String id;
    private String state;
    private long timestamp;
    private String host;
    private String type;
    private LocalDateTime logInputDate;
    private boolean alertFlag;

    public ServerLog(String id, String state, long timestamp, String host, String type, boolean flag) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.host = host;
        this.type = type;
        this.logInputDate = convertMillisecondsIntoDate(this.getTimestamp());
        this.alertFlag = false;
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
        return "ID: " + this.id + "\nSTATE: " + this.state + "\nTIME_STAMP: " + this.timestamp
                + "\nHOST: " + this.host + "\nTYPE: " + this.type;
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


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
