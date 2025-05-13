package com.ajayaraj.lodgesage.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/")
    public String getSample() {
        return "Hello, this is a sample response!";
    }

}
