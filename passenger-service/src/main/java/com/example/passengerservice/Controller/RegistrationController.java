package com.example.passengerservice.Controller;

import com.example.passengerservice.Model.Account;
import com.example.passengerservice.Model.Passenger;
import com.example.passengerservice.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.HeaderParam;

@RestController
public class RegistrationController {
    @Autowired
    AccountService accountService;


    @PostMapping("/CreateUser")
    public String createUser(Passenger passenger,String Password){
        Account account=new Account();
        account.setPassword(Password);
        account.setEmail(passenger.getEmail());
        return accountService.registrat(passenger,account);
    }
    @PostMapping("/user/accountInformation")
    public Passenger accountInformation(@RequestHeader("userName")String email){
     return null;
    }
    @PostMapping ("/user/updateAccount")
    public String updateAccount(@RequestHeader("userName")String email,Passenger passenger){
        String reponse=accountService.updatePassenger(email,passenger);
        return reponse;
    }
    @PostMapping ("/user/chanePassword")
    public String chanePassword(@RequestHeader("userName")String email,String oldPassword,String newPassword){
        String reponse=accountService.updatePassword(email,oldPassword,newPassword);
        return reponse;
    }

    @DeleteMapping("/user/delete")

    public String deleteAccount(@RequestHeader("userName")String email){
        return accountService.deleteAccount(email);
    }
}
