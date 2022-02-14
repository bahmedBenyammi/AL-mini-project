package com.example.arduinoservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RFIDService {
    @Autowired
    WebClient passenger;
    public boolean RFIDexist(String cart){
        boolean reponse=  passenger.get().uri(uriBuilder->uriBuilder.path("/RFID/findPassager/"+cart)
                .build()).retrieve().bodyToMono(Boolean.class).block();
        return reponse;
    }
}
