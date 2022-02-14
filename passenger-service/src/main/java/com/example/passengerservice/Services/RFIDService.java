package com.example.passengerservice.Services;

import com.example.passengerservice.Model.RFIDCarte;
import com.example.passengerservice.Respositories.PassengerResposirtory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RFIDService {
    @Autowired
    PassengerResposirtory passengerResposirtory;
    public boolean findPassger(String cart){
        RFIDCarte rfidCarte=new RFIDCarte();
        rfidCarte.setRFID(cart);
        return passengerResposirtory.existsByRfidCarte(rfidCarte);
    }
}
