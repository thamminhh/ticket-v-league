package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")

public class MatchController {

    @Autowired
    private MatchService service;

    @PostMapping()
    public Match addMatch(@RequestBody Match match){
        return service.saveMatch(match);
    }
    @GetMapping()
    public List<Match> findAllMatch(){
        return service.getMatch();
    }

    @GetMapping("/{id}")
    public Match findMatchByID(@PathVariable int id){
        return service.getMatchByID(id);
    }

    @GetMapping("stadiumId/{stadiumId}")
    public List <Match> findMatchByStadiumId(@PathVariable int stadiumId){
        return service.getMatchByStadiumId(stadiumId);
    }
    @GetMapping("clubHomeId/{clubHomeId}")
    public List <Match> findMatchByClubHomeId(@PathVariable int clubHomeId){
        return service.getMatchByClubHomeId(clubHomeId);
    }
    @GetMapping("clubVisitorId/{clubVisitorId}")
    public List <Match> findMatchByClubVisitorId(@PathVariable int clubVisitorId){
        return service.getMatchByClubVisitorId(clubVisitorId);
    }
    @PutMapping()
    public Match updateMatch(@RequestBody Match match){
        return service.saveMatch(match);
    }

    @DeleteMapping("/{id}")
    public String deleteMatch(@PathVariable int id){

        return service.deleteMatch(id);
    }
}
