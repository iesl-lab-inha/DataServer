package com.example.dataserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public Device(String type, String token, String serialNumber){
        this.type = type;
        this.token = token;
        this.serialNumber = serialNumber;
    }

    public long getCountForDate(LocalDate date){
        long counter = 0l;
        for(Data data : getData()){
            LocalDate localDate = LocalDate.ofInstant(data.getTime(), ZoneOffset.UTC);
            if(date.isEqual(localDate)){
                counter++;
            }
        }
        return counter;
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
