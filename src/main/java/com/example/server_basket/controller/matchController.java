package com.example.server_basket.controller;

import com.example.server_basket.entity.matchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.server_basket.service.matchService;
import java.util.List;

@RestController
public class matchController {
    @Autowired
    private matchService matchService;
    @GetMapping("/hello")
    public String hello(){
        return "bonjour";
    }

    @GetMapping("/getAll")
    public List<matchEntity> getAll(){
        return matchService.getAll();
    }
}
