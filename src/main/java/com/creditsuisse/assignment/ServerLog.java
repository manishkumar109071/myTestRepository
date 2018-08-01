package com.creditsuisse.assignment;

public class ServerLog {

    private String id;
    private String state;
    private long timestamp;
    private String host;
    private String type;

    public ServerLog(String id, String state, long timestamp, String host, String type) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.host = host;
        this.type = type;
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

    @Override
    public String toString() {
        return "ID: " + this.id + "\nSTATE: " + this.state + "\nTIME_STAMP: " + this.timestamp
                + "\nHOST: " + this.host + "\nTYPE: " + this.type;
    }
}
