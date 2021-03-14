package com.dsw.formoneplaceallocator.controllers;

import com.dsw.formoneplaceallocator.services.iface.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Security {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    String login() {
        return "login";
    }


}
