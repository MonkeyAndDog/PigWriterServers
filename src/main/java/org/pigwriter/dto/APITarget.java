package org.pigwriter.dto;

public class APITarget {
    private String data;
    private int state;
    private String message;

    public String getData() {
        return data;
    }

    public APITarget setData(String data) {
        this.data = data;
        return this;
    }

    public int getState() {
        return state;
    }

    public APITarget setState(int state) {
        this.state = state;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public APITarget setMessage(String message) {
        this.message = message;
        return this;
    }
}
