package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.Configuration.ConfigurationProperites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class LimitConfigurationController {

    @Autowired
    ConfigurationProperites configurationProperites;

    @GetMapping("/")
    public ConfigurationProperites getConfiguration(){
        return configurationProperites;
    }

    @GetMapping("test")
    public String dummyMethod(){
        return "limit-server";
    }

}
