package com.example.passengerservice.Respositories;

import com.example.passengerservice.Model.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyageRespository extends JpaRepository<Voyage,Long> {
}
