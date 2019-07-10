package com.soto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
//@Import({})
public class EurekaClientApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication2.class, args);
    }
}
