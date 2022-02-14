package com.example.passengerservice.Controller;

import com.example.passengerservice.Services.RFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RFIDController {
    @Autowired
    RFIDService rfidService;
    @GetMapping("/RFID/findPassager/{cartRFID}")
    public Boolean findPassager(@PathVariable String cartRFID ){
        System.out.println(cartRFID);
        return rfidService.findPassger(cartRFID);
    }
}
