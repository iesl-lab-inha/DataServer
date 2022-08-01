package com.example.dataserver.model;

import javax.persistence.*;

@Entity
@Table(name = "data_type")
public class DataType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "field")
    private int field;

    public DataType(){}

    public DataType(String name, int field) {
        this.name = name;
        this.field = field;
    }

    public DataType(long id, String name, int field) {
        this.id = id;
        this.name = name;
        this.field = field;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getField() {
        return field;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", field=" + field +
                '}';
    }
}
