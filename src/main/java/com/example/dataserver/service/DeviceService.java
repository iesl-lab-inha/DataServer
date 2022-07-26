package com.example.dataserver.service;

import com.example.dataserver.model.Device;
import com.example.dataserver.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device create(Device device){
        return deviceRepository.save(device);

    }
}
