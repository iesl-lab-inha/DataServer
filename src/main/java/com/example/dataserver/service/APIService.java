package com.example.dataserver.service;

import com.example.dataserver.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface APIService {

    List<Data> getAll();
    ClientResponse register(Device device);
    ClientResponse upload(UploadRequest data);
    Device deviceInfo(Device device);
}
