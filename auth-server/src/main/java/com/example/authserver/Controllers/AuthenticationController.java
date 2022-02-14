package com.example.authserver.Controllers;


import com.example.authserver.Models.Account;
import com.example.authserver.ReQResp.AuthReq;
import com.example.authserver.ReQResp.AuthResp;
import com.example.authserver.jwt.JwtUtil;
import com.example.authserver.services.MyUserDetailsService;
import com.example.authserver.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    RegistrationService registrationService;


    @PostMapping("/login")
    public ResponseEntity<?> generateToken(AuthReq authReq) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword())
            );

        } catch (BadCredentialsException e) {
            System.out.println("Incorrect username or password" + authReq.getPassword() + " " + authReq.getUsername());
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authReq.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthResp(jwt));

    }

    @PostMapping("/registration/CreateUser")
    public String validtoken(Account account) {
        return registrationService.CreateUser(account);
    }
    @DeleteMapping("/deleteAccount/{email}")
    public String deleteAccount(@PathVariable String email){
        return registrationService.deleteAccount(email);
    }
}
