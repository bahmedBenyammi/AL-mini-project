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
    @Autowired
    PassengerResposirtory passengerResposirtory;

    public static void main(String[] args) {
        SpringApplication.run(PassengerServiceApplication.class, args);
    }
    @Bean
    public void test(){
        Passenger passenger=new Passenger();
        passenger.setEmail("sadsd");
        passenger.setFirstName("afaf");
        passenger.setLastName("asda");
        passengerResposirtory.save(passenger);

    }

}
