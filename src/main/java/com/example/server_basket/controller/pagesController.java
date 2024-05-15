package com.example.server_basket.controller;

import com.example.server_basket.entity.matchEntity;
import com.example.server_basket.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class pagesController {

    @Autowired
    private com.example.server_basket.service.matchService matchService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
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

    @PostMapping("/login/success")
    public String success(){
        return "redirect:/dashboard";
    }

    @GetMapping("/addMatch")
    public String addMatch(){
        return "addMatch";
    }

    @GetMapping("/modifyMatch")
    public String modifyMatch(@RequestParam("id") Long matchId, Model model){
        matchEntity match=matchService.findMatch(String.valueOf(matchId));
        model.addAttribute("match", match);
        return "modifyMatch";
    }
}
