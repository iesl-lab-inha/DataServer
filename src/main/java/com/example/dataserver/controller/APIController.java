package com.example.dataserver.controller;

import com.example.dataserver.model.*;
import com.example.dataserver.service.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    APIServiceImpl apiService;

    @PostMapping("/register")
    public ClientResponse register(@RequestBody Device device){
        return apiService.register(device);
    }

    @PostMapping("/upload")
    public ClientResponse upload(@RequestBody UploadRequest data){
        return apiService.upload(data);
    }

    @GetMapping("/info")
    public Device deviceInfo(@RequestBody Device device){
        return apiService.deviceInfo(device);
    }

    @GetMapping("/all")
    public List<Data> getAll(){
        return apiService.getAll();
    }
}
