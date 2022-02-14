package com.example.authserver.services;

import com.example.authserver.Models.Account;
import com.example.authserver.Repos.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateAccountService {
    @Autowired
    AccountRespository respository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public String ChangeEmail(String oldEmail,String newEmail){
        if(!respository.existsByEmail(newEmail))
        {
          List<Account> accounts= respository.findByEmail(oldEmail);
          if (accounts.size()==1)
          {
              Account account=accounts.get(0);
              account.setEmail(newEmail);
              respository.save(account);
              return "success";

          }else
              return "email exist many time";

        }
        else
            return "email already exist ";
    }
    public String changePassword(String email,String oldPassword,String newPassword){
        List<Account> accounts= respository.findByEmail(email);
        if (accounts.size()==1)
        {
            Account account=accounts.get(0);
            String enPasswor=passwordEncoder.encode(oldPassword);
            if(enPasswor.equals(account.getPassword()))
            {
              account.setPassword(passwordEncoder.encode(newPassword));
              respository.save(account);
                return "success";
            }else
                return "old is password incorrect";
        }else{
            return "account not found";
        }
    }
}
