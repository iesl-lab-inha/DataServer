package com.example.dataserver.service;

import com.example.dataserver.model.Data;
import com.example.dataserver.model.DataType;
import com.example.dataserver.model.Device;
import com.example.dataserver.repository.DataRepository;
import com.example.dataserver.repository.DataTypeRepository;
import com.example.dataserver.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WebService {

    @Autowired
    DataRepository dataRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    public List<Data> getAllData(){
        return dataRepository.findAll();
    }

    public List<Device> getAllDevices(){
        return deviceRepository.findAll();
    }

    public List<String> getDeviceIdList(){
        List<Device> devices = deviceRepository.findAll();
        List<String> response = new ArrayList<>();
        for (Device device:devices) {
            response.add(device.getId() + "");
        }
        return response;
    }

    public List<String> getTimeIntervalList(){
        List<Device> devices = deviceRepository.findAll();
        List<String> response = new ArrayList<>();

        List<Data> dataList = dataRepository.findAllByOrderByTimeAsc();
        LocalDate first = LocalDate.ofInstant(dataList.get(0).getTime(), ZoneOffset.UTC);
        LocalDate last = LocalDate.ofInstant(dataList.get(dataList.size()-1).getTime(), ZoneOffset.UTC);

        for(LocalDate date = first; !date.isAfter(last); date = date.plusDays(1)){
            response.add(date.toString());
        }

        return response;
    }

    public List<List<Long>> getDataCountList(){
        List<Device> devices = deviceRepository.findAll();
        List<List<Long>> response = new ArrayList<>();
        int index = 0;
//        List<Long> innerList = new ArrayList<>();

        List<Data> dataList = dataRepository.findAllByOrderByTimeAsc();
        LocalDate first = LocalDate.ofInstant(dataList.get(0).getTime(), ZoneOffset.UTC);
        LocalDate last = LocalDate.ofInstant(dataList.get(dataList.size()-1).getTime(), ZoneOffset.UTC);


        for(LocalDate date = first; !date.isAfter(last); date = date.plusDays(1)){
            response.add(new ArrayList<>());
        }

        for(LocalDate date = first; !date.isAfter(last); date = date.plusDays(1)){
            for (Device device:devices) {
                response.get(index).add(device.getCountForDate(date));
            }
            index++;
        }

        return response;
    }



    public void deleteDeviceById(long id){
        deviceRepository.deleteById(id);
    }

    public void deleteDataById(long id){
        dataRepository.deleteById(id);
    }

    public void randomSetup(){
        List<Device> devices = deviceRepository.findAll();
        List<Data> dataList = new ArrayList<>();
        Random rand = new Random();

        LocalDateTime prev = LocalDateTime.of(LocalDate.from(LocalDateTime.now().minusDays(10)), LocalTime.of(12, 10, 10));

        DataType dataType = dataTypeRepository.findTopByName("RANDOM_DATA");
        if(dataType == null){
            dataType = dataTypeRepository.save(new DataType("RANDOM_DATA", 1));
        }

        while (devices.size() < 5){
            devices.add(deviceRepository.save(new Device("SIMULATION", getRandomString(32), getRandomSerialNumber())));
        }

        for(int i = 0; i < 10; i++) {
            Instant instant = LocalDateTime.of(LocalDate.from(prev.plusDays(i)), LocalTime.of(12, 10, 10)).toInstant(ZoneOffset.UTC);
            for (Device device : devices) {
                int count = rand.nextInt(10) + 1;
                for(int j = 0; j < count; j++){
                    String stringData = getRandomString(32);
                    Data data = new Data();
                    data.setDevice(device);
                    data.setDataType(dataType);
                    data.setDataString(stringData);
                    data.setTime(instant);
                    dataList.add(data);
                }
            }
        }

        dataRepository.saveAll(dataList);

    }


    static String getRandomString(int n){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    static String getRandomSerialNumber(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 3; i++) {
            int index = (int)(chars.length() * Math.random());
            sb.append(chars.charAt(index));
        }

        for (int i = 3; i < 15; i++) {
            int index = (int)(numbers.length() * Math.random());
            sb.append(numbers.charAt(index));
        }

        return sb.toString();
    }
}
