package com.soto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/hello1")
    public String hello1() {
        return restTemplate.getForEntity("http://SERVICE-HELLO/hello1", String.class).getBody();
    }



    @GetMapping("/hello2")
    public String hello2() {
        return restTemplate.getForEntity("http://SERVICE-HELLO-2/hello2", String.class).getBody();
    }
}
