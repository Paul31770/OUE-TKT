package com.example.server_basket.controller;

import com.example.server_basket.entity.matchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private com.example.server_basket.service.matchService matchService;

    @GetMapping("secured/dashboard")
    public String index(Model model){
        List<matchEntity> matches = matchService.getAll();
        model.addAttribute("matches", matches);
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login/success")
    public String success(){
        return "redirect:/secured/dashboard";
    }

    @GetMapping("secured/addMatch")
    public String addMatch(){
        return "addMatch";
    }

}
