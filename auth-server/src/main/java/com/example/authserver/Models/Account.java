package com.example.authserver.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class Account {
    @Id
    private String Id;
    private String email;
    private String password;
    private Set<Roles> roles;
}
