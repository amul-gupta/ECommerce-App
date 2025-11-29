package com.example.Payment_Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderClientConfig {

    @Bean
    public RestTemplate getRestTemplateObject()
    {
        return new RestTemplate();
    }
}
