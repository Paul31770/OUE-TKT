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
    public String hello(){
        return "index";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        /*return matchService.getAll();*/
        List<matchEntity> matches = matchService.getAll();
        System.out.println(matches);
        model.addAttribute("matches", matches);
        return "index";
    }

    @PostMapping("/addMatch")
    public ResponseEntity addMatch(@RequestBody inputMatchDto dto){
        return new ResponseEntity(matchService.addMacth(dto), HttpStatus.OK);

    }

    @GetMapping("/recoMatchFinish")
    public List<matchEntity> recoMatchFinish(){

        return matchService.getAllMatchFinish();
    }
}
