package com.example.dataserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String token;

    private String serialNumber;

    public Device(){}

    public Device(String type, String token, String serialNumber) {
        this.type = type;
        this.token = token;
        this.serialNumber = serialNumber;
    }

    public Device(int id, String type, String token, String serialNumber) {
        this.id = id;
        this.type = type;
        this.token = token;
        this.serialNumber = serialNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", token='" + token + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
