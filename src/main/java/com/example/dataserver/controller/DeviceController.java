package com.example.dataserver.controller;

import com.example.dataserver.model.Device;
import com.example.dataserver.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/device")
    public Device create(@RequestBody Device body){
        return deviceService.create(body);
    }
}
