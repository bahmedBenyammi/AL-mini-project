package com.example.passengerservice.Respositories;

import com.example.passengerservice.Model.Reservastion;
import com.example.passengerservice.Model.ReservationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservastion, ReservationKey> {
}
