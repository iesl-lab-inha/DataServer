package com.example.dataserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s !!!", name);
    }


}
