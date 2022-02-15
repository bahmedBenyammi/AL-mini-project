package com.example.authserver.ReQResp;

import lombok.Data;

import java.io.Serializable;
@Data
public class AuthReq implements Serializable {

    private String email;
    private String password;



}
