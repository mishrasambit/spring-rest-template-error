package com.speed.mixer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.speed.mixer.util.AppResponseErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sambit on 3/16/2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.speed.mixer.service"})
public class ServiceConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate  restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new AppResponseErrorHandler());
        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
}
