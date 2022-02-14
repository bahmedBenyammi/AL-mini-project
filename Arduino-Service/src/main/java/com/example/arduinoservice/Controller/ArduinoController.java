package com.example.arduinoservice.Controller;

import com.example.arduinoservice.Service.RFIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArduinoController {
@Autowired
    RFIDService rfidService;
@GetMapping("/findPassenger/{carte}")
public boolean findPassenger(@PathVariable String carte){
    System.out.println(carte);
    return rfidService.RFIDexist(carte);
}
}
