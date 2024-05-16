package com.example.server_basket.controller;

import com.example.server_basket.entity.matchEntity;
import com.example.server_basket.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobileController {
    @Autowired
    private matchService matchService;

    @GetMapping("public/mobileFinishedMatches")
    public ResponseEntity mobileFinishedMatches(){
        List<matchEntity> matches = matchService.getAllMatchFinish();
        return new ResponseEntity(matches, HttpStatus.OK);
    }


    @GetMapping("public/mobileCurrentMatches")
    public ResponseEntity mobileCurrentMatches(){
        List<matchEntity> matches =  matchService.getAllMatchCurrent();
        return new ResponseEntity(matches, HttpStatus.OK);
    }

}
