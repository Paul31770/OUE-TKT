package com.example.server_basket.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="matchDB")
public class matchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="name_team1")
    private String name_team1;

    @Column(name="name_team2")
    private String name_team2;

    @Column(name="score_team1")
    private Integer score_team1;

    @Column(name="score_team2")
    private Integer score_team2;

    @Column(name="status")
    private String status;

    @Column(name="date")
    private LocalDate date;

    @Column(name="logo_team1")
    private String logo_team1;

    @Column(name="logo_team2")
    private String logo_team2;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName_team1() {
        return name_team1;
    }

    public void setName_team1(String name_team1) {
        this.name_team1 = name_team1;
    }

    public String getName_team2() {
        return name_team2;
    }

    public void setName_team2(String name_team2) {
        this.name_team2 = name_team2;
    }

    public Integer getScore_team1() {
        return score_team1;
    }

    public void setScore_team1(Integer score_team1) {
        this.score_team1 = score_team1;
    }

    public Integer getScore_team2() {
        return score_team2;
    }

    public void setScore_team2(Integer score_team2) {
        this.score_team2 = score_team2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLogo_team1() {
        return logo_team1;
    }

    public void setLogo_team1(String logo_team1) {
        this.logo_team1 = logo_team1;
    }

    public String getLogo_team2() {
        return logo_team2;
    }

    public void setLogo_team2(String logo_team2) {
        this.logo_team2 = logo_team2;
    }
}
