package com.example.passengerservice.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservastion {
    @Id
    private ReservationKey reservationKey;
    @ManyToOne
    @MapsId("passengerId")
    @JoinColumn(name="passenger_id")
    private Passenger passenger;
    @ManyToOne
    @MapsId("voyageId")
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    private boolean valid;
}
