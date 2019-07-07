package com.soto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication2.class, args);
    }
}
