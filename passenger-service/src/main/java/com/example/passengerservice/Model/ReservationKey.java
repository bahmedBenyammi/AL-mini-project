package com.example.passengerservice.Model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class ReservationKey implements Serializable {
    private long passengerId;
    private long voyageId;
    private Date date;

}
