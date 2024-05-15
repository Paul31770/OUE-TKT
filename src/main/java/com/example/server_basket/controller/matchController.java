package com.example.server_basket.controller;

import com.example.server_basket.dto.inputMatchDto;
import com.example.server_basket.entity.matchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.server_basket.service.matchService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class matchController {
    @Autowired
    private matchService matchService;

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<matchEntity> matches = matchService.getAll();
        model.addAttribute("matches", matches);
        return "index";
    }

    @PostMapping("/addMatchPost")
    public String addMatch(inputMatchDto dto) {
        try {
            matchService.addMacth(dto);
            return "redirect:/dashboard";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/recoMatchFinish")
    public List<matchEntity> recoMatchFinish() {

        return matchService.getAllMatchFinish();
    }
}
