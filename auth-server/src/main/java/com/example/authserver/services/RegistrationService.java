package com.example.authserver.services;

import com.example.authserver.Models.Account;
import com.example.authserver.Models.Roles;
import com.example.authserver.Repos.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {
    @Autowired
    AccountRespository respository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public String CreateUser(Account account){
        boolean exists = respository.existsByEmail(account.getEmail());
        if(exists)
            return "email or username has existe";
        else
        {   Set<Roles> rolesSet=new HashSet<>();
            rolesSet.add(Roles.USER);
            account.setRoles(rolesSet);
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            respository.save(account);
            return "Success";
        }
    }
    public String deleteAccount(String email){
       boolean b= respository.deleteByEmail(email);
        if (b)
            return "success";
        else
            return "erreur";
    }
}
