package com.example.server_basket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class pagesController {

    @PostMapping("/dashboard")
    public String index(){
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
