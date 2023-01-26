package com.az.ejemplobddos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class ConfigDev {


    @PostConstruct
    public void mensaje() {
        System.out.println("CONFIG DEV");
    }

}
