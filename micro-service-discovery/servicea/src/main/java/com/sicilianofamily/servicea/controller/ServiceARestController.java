package com.sicilianofamily.servicea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceARestController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World! from Service A";
    }

}
