package com.example.server_basket.controller;

import com.example.server_basket.entity.matchEntity;
import com.example.server_basket.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class pagesController {

    @Autowired
    private com.example.server_basket.service.matchService matchService;

    @GetMapping("/dashboard")
    public String index(Model model){
        List<matchEntity> matches = matchService.getAll();
        model.addAttribute("matches", matches);
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/successLogin")
    public String successLogin(){
        return "redirect:/dashboard";
    }

    @GetMapping("/addMatch")
    public String addMatch(){
        return "addMatch";
    }

}
