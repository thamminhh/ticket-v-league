package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchesInfoDTO {
    private int machId;
    private int roundId;
    private int stadiumId;
    private int clubHomeId;
    private int clubVisitorId;
    private String timeStart;
    private int idStadium;
    private String stadiumName;
    private String location;
    private String capacity;
    private String img;
    private int idCLubHome;
    private int clubHomeStadiumId;
    private String clubHomeName;
    private String clubHomeImg;
    private String clubHomeCountry;
    private int idCLubVisitor;
    private int clubVisitorStadiumId;
    private String clubVisitorName;
    private String clubVisitorImg;
    private String clubVisitorCountry;
}



