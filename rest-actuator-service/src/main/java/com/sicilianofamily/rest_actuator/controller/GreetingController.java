package com.sicilianofamily.rest_actuator.controller;

import com.sicilianofamily.rest_actuator.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello from Spring Actuator, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // http://localhost:9001/actuator/health
    // http://localhost:9000/hello?name=Mike
}
