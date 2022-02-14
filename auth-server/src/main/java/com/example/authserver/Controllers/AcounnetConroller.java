package com.example.authserver.Controllers;

import com.example.authserver.services.UpdateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

@RestController("/user")
public class AcounnetConroller {
    @Autowired
    UpdateAccountService updateAccountService;
    @PostMapping("/changeEmail")
    public String changeEmail(String oldEmail,String newEmail){
       return updateAccountService.ChangeEmail(oldEmail,newEmail);
    }
    @PostMapping("/changePassword")
    public String changeEmail(String email,String oldPassword,String newPassword){
        return updateAccountService.changePassword(email,oldPassword,newPassword);
    }

}
