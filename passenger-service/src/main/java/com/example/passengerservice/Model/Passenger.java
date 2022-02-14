package com.example.passengerservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_gen")
    @SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq", allocationSize = 1)
    private long id;
    private String email;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    //  private String subscriptionType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date registrationDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    @OneToOne
    @JoinColumn(name = "CARTE_RFID", referencedColumnName = "rfid")
    private RFIDCarte rfidCarte;


}
