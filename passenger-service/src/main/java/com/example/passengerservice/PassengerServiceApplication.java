package com.example.passengerservice;

import com.example.passengerservice.Model.Passenger;
import com.example.passengerservice.Respositories.PassengerResposirtory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PassengerServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(PassengerServiceApplication.class, args);
    }


}
