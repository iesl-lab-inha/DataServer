package com.example.dataserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "token")
    private String token;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> records) {
        this.data = records;
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
