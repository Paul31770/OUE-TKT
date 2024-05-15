package com.example.server_basket.service;

import com.example.server_basket.repository.matchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server_basket.entity.matchEntity;

import java.util.List;

@Service
public class matchService {
    @Autowired
    private matchRepository matchRepo;

    public List<matchEntity> getAll(){
        return matchRepo.findAll();
    }

    public List<matchEntity> getAllMatchFinish(){

        return null;
    }

    public  List<matchEntity> getAllMatchCurrent(){

        return null;
    }
}
