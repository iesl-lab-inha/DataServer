package com.example.dataserver.model;

public class UploadRequest {
    private String token;
    private String source;
    private String time;
    private String data;
    private String description;

    public UploadRequest(){}

    public void setToken(String token) {
        this.token = token;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public String getSource() {
        return source;
    }

    public String getTime() {
        return time;
    }

    public String getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }
}
