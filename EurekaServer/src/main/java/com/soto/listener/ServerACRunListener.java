package com.soto.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ServerACRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;

    public ServerACRunListener(SpringApplication application, String[] args) {

        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("ServerACRunListener.....  starting");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("ServerACRunListener.......  environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("ServerACRunListener........  contextPrepared");

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("ServerACRunListener......  contextLoaded");

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("ServerACRunListener......finished  ");

    }
}
