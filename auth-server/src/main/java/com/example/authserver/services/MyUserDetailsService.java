package com.example.authserver.services;

import com.example.authserver.Models.Account;
import com.example.authserver.Repos.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRespository accountRespository;


    @Override
    public UserPrincipal loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Account> users =accountRespository.findByEmail(s);
        if(users.size()!=1)
            throw new UsernameNotFoundException("User 404");
        return new UserPrincipal(users.get(0));
    }
}
