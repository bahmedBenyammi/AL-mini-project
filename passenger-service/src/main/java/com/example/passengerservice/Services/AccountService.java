package com.example.passengerservice.Services;

import com.example.passengerservice.Model.Account;
import com.example.passengerservice.Model.Passenger;

import com.example.passengerservice.Respositories.PassengerResposirtory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class AccountService {

    @Autowired
    WebClient authService;
    @Autowired
    PassengerResposirtory passengerResposirtory;

    public String registrat(Passenger passenger, Account account){
        passenger.setEmail(passenger.getEmail().toLowerCase(Locale.ROOT));
        if (passengerResposirtory.existsByEmail(passenger.getEmail()))
            return "email already exist";
      String reponse=  authService.post().uri(uriBuilder->uriBuilder.path("/registration/CreateUser").queryParam("email",account.getEmail()).
                queryParam("password",account.getPassword()).build()).retrieve().bodyToMono(String.class).block();
      if(reponse.equals("Success")) {
          passenger.setRegistrationDate(new Date());
          passengerResposirtory.save(passenger);

      }
        System.out.println("reponse :"+reponse);
       return reponse;
    }
    public Passenger AccountInformation(String email){
        List<Passenger>passengers =passengerResposirtory.findByEmail(email);
        if(passengers.size()==1)
            return passengers.get(0);
        return null;
    }
    public String updatePassenger(String email ,Passenger passenger){
        Passenger passenger1=passengerResposirtory.findByEmail(email).get(0);
        if(!email.equals(passenger.getEmail()))
        {

            String reponse=  authService.post().uri(uriBuilder->uriBuilder.path("/user/changeEmail")
                    .queryParam("oldEmail",email).
                    queryParam("newEmail",passenger.getEmail())
                    .build()).retrieve().bodyToMono(String.class).block();
            if (!reponse.equals("success"))

            return reponse;}
        passenger.setId(passenger1.getId());
        passengerResposirtory.save(passenger);
        return null;
    }
    public String updatePassword(String email,String oldPassword,String newPassord){
        String reponse=  authService.post().uri(uriBuilder->uriBuilder.path("/user/changePassword")
                .queryParam("email",email).
                        queryParam("oldPassword",oldPassword)
                .queryParam("newPassord",newPassord)
                .build()).retrieve().bodyToMono(String.class).block();
        return reponse;
    }
    public String deleteAccount(String email){
        String reponse=  authService.delete().uri(uriBuilder->uriBuilder.path("/deleteAccount/"+email)
                .build()).retrieve().bodyToMono(String.class).block();
        return reponse;
    }

}
