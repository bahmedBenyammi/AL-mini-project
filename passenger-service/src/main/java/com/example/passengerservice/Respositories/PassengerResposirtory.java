package com.example.passengerservice.Respositories;

import com.example.passengerservice.Model.Passenger;
import com.example.passengerservice.Model.RFIDCarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerResposirtory extends JpaRepository<Passenger,Long> {
    List<Passenger> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByRfidCarte(RFIDCarte carte);
}
