package com.example.passengerservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Entity
@Data
public class Voyage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String destination;
    private String demarche;
    @JsonFormat(pattern = "hh:mm:ss")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time time;
}
