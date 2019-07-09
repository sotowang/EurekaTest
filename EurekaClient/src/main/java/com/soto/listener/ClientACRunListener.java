package com.soto.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ClientACRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;

    public ClientACRunListener(SpringApplication application, String[] args) {

        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("clientACRunListener.....  starting");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("clientACRunListener.......  environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("clientACRunListener........  contextPrepared");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("clientACRunListener......  contextLoaded");

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("clientACRunListener......finished  ");

    }
}
