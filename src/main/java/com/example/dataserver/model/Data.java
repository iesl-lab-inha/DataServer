package com.example.dataserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private DataType dataType;

    @Column(name = "time")
    private Instant time;

    @Column(name = "data_int")
    private int dataInt;

    @Column(name = "data_float")
    private float dataFloat;

    @Column(name = "data_string")
    private String dataString;

    @Column(name = "description")
    private String description;

    public Data(){}

    public Data(Device device, DataType dataType, Instant time, int dataInt, float dataFloat, String dataString, String description) {
        this.device = device;
        this.dataType = dataType;
        this.time = time;
        this.dataInt = dataInt;
        this.dataFloat = dataFloat;
        this.dataString = dataString;
        this.description = description;
    }

    public Data(long id, Device device, DataType dataType, Instant time, int dataInt, float dataFloat, String dataString, String description) {
        this.id = id;
        this.device = device;
        this.dataType = dataType;
        this.time = time;
        this.dataInt = dataInt;
        this.dataFloat = dataFloat;
        this.dataString = dataString;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Instant getTime() {
        return time;
    }

    public int getDataInt() {
        return dataInt;
    }

    public float getDataFloat() {
        return dataFloat;
    }

    public String getDataString() {
        return dataString;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public void setDataInt(int dataInt) {
        this.dataInt = dataInt;
    }

    public void setDataFloat(float dataFloat) {
        this.dataFloat = dataFloat;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", device=" + device +
                ", dataType=" + dataType +
                ", time=" + time +
                ", dataInt=" + dataInt +
                ", dataFloat=" + dataFloat +
                ", dataString='" + dataString + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
