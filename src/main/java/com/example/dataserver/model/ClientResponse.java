package com.example.dataserver.model;

public class ClientResponse {
    private String message;
    private String token;
    private long id;

    public ClientResponse(){}

    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public long getId() {
        return id;
    }
}
