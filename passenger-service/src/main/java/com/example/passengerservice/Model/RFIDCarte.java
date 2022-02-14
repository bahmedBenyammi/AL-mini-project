package com.example.passengerservice.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "RFID_CARTE")
public class RFIDCarte {
    @Id
    private String RFID;
    private Date ExpirationDate;
}
