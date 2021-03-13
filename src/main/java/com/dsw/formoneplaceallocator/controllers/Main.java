package com.dsw.formoneplaceallocator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
    @RequestMapping(value = {"/", "/home"})
    String main() {
        return "index";
    }


    @GetMapping("/test")
    @ResponseBody
    String test() {
        return "Form one registration system GUI up!!!";
    }
}
