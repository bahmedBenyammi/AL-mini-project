package com.example.passengerservice.Services;

import com.example.passengerservice.Model.Voyage;
import com.example.passengerservice.Respositories.VoyageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageService {
    @Autowired
    VoyageRespository voyageRespository;
    public List<Voyage> voyageList(){
        return voyageRespository.findAll();
    }
}
