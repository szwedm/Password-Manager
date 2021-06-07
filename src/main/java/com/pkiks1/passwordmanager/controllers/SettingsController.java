package com.pkiks1.passwordmanager.controllers;

import com.pkiks1.passwordmanager.security.PasswordManagerUser;
import com.pkiks1.passwordmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.auth.login.CredentialException;
import java.util.Map;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @GetMapping
    public String getSettings(Model model) {
        PasswordManagerUser user = (PasswordManagerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("userId", user.getId());
        return "settings";
    }

    @PostMapping
    public String editUser(
            @RequestParam(value = "changePassword", required= false, defaultValue = "false") boolean changePassword,
                           @RequestParam(name = "userId") String userId,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "currentPassword") char[] firstPassword,
                           @RequestParam(name = "newPassword") char[] newPassword,
                           @RequestParam(name = "newPasswordSecond") char[] newPasswordSecond,
                           @RequestParam Map<String,String> allParams,
                           Model model) {
        PasswordManagerUser user = (PasswordManagerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("passedParams",  allParams.entrySet());

        if(userId.equals(user.getId()))
        {
            //todo check current password, update password
            //wybrano zmiane hasla jeśli changePassword="on"
            model.addAttribute("error", false);
        }
        else
        {
            model.addAttribute("error", "Wystąpił błąd");//zalogowano na inne konto lub zmieniono username w ukrytym input
        }

        model.addAttribute("username", user.getUsername());
        model.addAttribute("userId", user.getId());
        return "settings";
    }


}

