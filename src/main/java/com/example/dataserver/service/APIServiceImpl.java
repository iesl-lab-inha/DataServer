package com.example.dataserver.service;

import com.example.dataserver.model.*;
import com.example.dataserver.repository.DataRepository;
import com.example.dataserver.repository.DataTypeRepository;
import com.example.dataserver.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class APIServiceImpl implements APIService{

    @Autowired
    DataRepository dataRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public List<Data> getAll(){
        return dataRepository.findAll();
    }

    @Override
    public ClientResponse register(Device device) {
        ClientResponse response = new ClientResponse();
        if(device.getSerialNumber() == null || device.getSerialNumber().isEmpty()){
            response.setMessage("Serial Number must be included in the request!");
            response.setToken("");
        }else {
            if(device.getType() == null || device.getType().isEmpty()){
                device.setType("PHONE");
            }
            List<Device> devices = deviceRepository.findBySerialNumber(device.getSerialNumber());
            if (!devices.isEmpty()) {
                response.setToken(devices.get(0).getToken());
                response.setMessage("This device is already registered!");
            } else {
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                device.setToken(token);
                Device d = deviceRepository.save(device);

                response.setToken(token);
                response.setMessage("Success!");
            }
        }
        return response;
    }

    @Override
    public ClientResponse upload(UploadRequest data) {
        ClientResponse response = new ClientResponse();
        if(data.getToken() == null || data.getToken().isEmpty()){
            response.setMessage("ERROR! Token must be included in the request");
            return response;
        }
        if(data.getData() == null || data.getData().isEmpty()){
            response.setMessage("ERROR! Data is empty!!!");
            return response;
        }
        if(data.getSource() == null || data.getSource().isEmpty()){
            data.setSource("UNDEFINED");
        }
        if(data.getTime() == null || data.getTime().isEmpty()){
            data.setTime(Instant.now().toString());
        }

        DataType type = dataTypeRepository.findTopByName(data.getSource());
        if(type == null){
            type = dataTypeRepository.save(new DataType(data.getSource(), 1));
        }
        Device device = deviceRepository.findTopByToken(data.getToken());
        if(device == null){
            response.setMessage("ERROR! Token does not exist!");
            return response;
        }
        Data record = new Data();
        record.setDevice(device);
        record.setDataType(type);
        record.setTime(Instant.parse(data.getTime()));
        record.setDataString(data.getData());
        record.setDescription(data.getDescription());

        Data result = dataRepository.save(record);
        response.setMessage("Success!");
        response.setId(result.getId());

        return response;
    }

    @Override
    public Device deviceInfo(Device device) {
        return deviceRepository.findTopByToken(device.getToken());
    }

    @Override
    public ClientResponse deleteAllData() {
        ClientResponse response = new ClientResponse();
        dataRepository.deleteAll();
        response.setMessage("All Data Deleted Successfully");
        return response;
    }
}
