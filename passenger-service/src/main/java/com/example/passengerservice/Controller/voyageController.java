package com.example.passengerservice.Controller;

import com.example.passengerservice.Model.Voyage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class voyageController {
    @GetMapping("/user/listVoyage")
    public ArrayList<Voyage> listVoyage(){
        return null;
    }
}
