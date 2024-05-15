package com.example.server_basket.service;

import com.example.server_basket.dto.inputMatchDto;
import com.example.server_basket.repository.matchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server_basket.entity.matchEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class matchService {
    @Autowired
    private matchRepository matchRepo;

    public List<matchEntity> getAll(){
        return matchRepo.findAll();
    }

    public Integer addMacth(inputMatchDto dto){
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        matchEntity match= new matchEntity();
        match.setName_team1(dto.getName_team1());
        match.setName_team2(dto.getName_team2());
        match.setScore_team1(dto.getScore_team1());
        match.setScore_team2(dto.getScore_team2());
        match.setStatus(dto.getStatus());
        match.setDate(date);
        match.setLogo_team1(dto.getLogo_team1());
        match.setLogo_team2(dto.getLogo_team2());

        matchRepo.saveAndFlush(match);
        return match.getID();
    }

    public List<matchEntity> getAllMatchFinish(){
        LocalDate date= LocalDate.now();
        List<matchEntity> listMatchFinish= new ArrayList<>();
        List<matchEntity> listAllMatch= matchRepo.findAll();
        for ( matchEntity match : listAllMatch){
            Long betweenDate = ChronoUnit.DAYS.between(match.getDate(),date);
            if (betweenDate<=7 && match.getStatus().equals("Terminé")){
                listMatchFinish.add(match);
            }
        }
        return listMatchFinish;
    }

    public  List<matchEntity> getAllMatchCurrent(){
        LocalDate date= LocalDate.now();
        List<matchEntity> listMatchCurrent= new ArrayList<>();
        List<matchEntity> listAllMatch= matchRepo.findAll();
        for ( matchEntity match : listAllMatch){
            Long betweenDate = ChronoUnit.DAYS.between(match.getDate(),date);
            if (betweenDate<=7 && match.getStatus().equals("En cours")){
                listMatchCurrent.add(match);
            }
        }
        return listMatchCurrent;
    }

    public Integer modifyMatch(String id, inputMatchDto dto){
        LocalDate date=LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        matchEntity entity= matchRepo.findById(Integer.valueOf(id)).get();
        entity.setName_team1(dto.getName_team1());
        entity.setName_team2(dto.getName_team2());
        entity.setScore_team1(dto.getScore_team1());
        entity.setScore_team2(dto.getScore_team2());
        entity.setStatus(dto.getStatus());
        entity.setDate(date);
        entity.setLogo_team1(dto.getLogo_team1());
        entity.setLogo_team2(dto.getLogo_team2());

        matchRepo.save(entity);
        return entity.getID();
    }

    public Boolean exist(Integer id) {
        return matchRepo.existsById(id);
    }
}
