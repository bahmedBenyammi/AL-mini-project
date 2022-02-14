package com.example.passengerservice.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Locale;

@Configuration
public class WebClientMirocService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Bean
    public WebClient authService(){
        String uri= discoveryClient.getInstances("authentication".toUpperCase(Locale.ROOT)).get(0).getUri().toString();
        return WebClient.create(uri);

    }
}
