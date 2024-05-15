package com.example.server_basket.controller;

import com.example.server_basket.dto.inputMatchDto;
import com.example.server_basket.entity.matchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.server_basket.service.matchService;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private matchService matchService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<matchEntity> matches = matchService.getAll();
        model.addAttribute("matches", matches);
        return "index";
    }

    @PostMapping("secured/addMatchPost")
    public String addMatch(inputMatchDto dto) {
        try {
            matchService.addMacth(dto);
            return "redirect:/secured/dashboard";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/finishedMatches")
    public String finishedMatches(RedirectAttributes ra){
        List<matchEntity> matches = matchService.getAllMatchFinish();
        ra.addFlashAttribute("matches", matches);
        return "redirect:/";

    }

    @GetMapping("/currentMatches")
    public String currentMatches(RedirectAttributes ra){
        List<matchEntity> matches = matchService.getAllMatchCurrent();
        ra.addFlashAttribute("matches", matches);
        return "redirect:/";
    }

    @PostMapping("/modifyMatch/{id}")
    public ResponseEntity modifyMatch(@PathVariable String id, @RequestBody inputMatchDto dto){
        if(!(matchService.exist(Integer.valueOf(id)))){
            return new ResponseEntity("Le match n'existe pas", HttpStatus.OK);
        }
        else{
            return new ResponseEntity(matchService.modifyMatch(id, dto), HttpStatus.OK);
        }
    }
}
