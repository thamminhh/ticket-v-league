package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Round;
import com.example.demo_tss.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoundController {
    @Autowired
    private RoundService service;

    @PostMapping("/addRound")
    public Round addRound(@RequestBody Round round){
        return service.saveRound(round);
    }
    @GetMapping("/getRounds")
    public List<Round> findAllRound(){
        return service.getRound();
    }

    @GetMapping("/getRoundById/{id}")
    public Round findRoundByID(@PathVariable int id){
        return service.getRoundByID(id);
    }

    @GetMapping("getRoundByTournamentId/{tournamentId}")
    public List <Round> findRoundByTournamentId(@PathVariable int tournamentId){
        return service.getRoundByTournamentId(tournamentId);
    }

    @PutMapping("/updateRound")
    public Round updateRound(@RequestBody Round round){
        return service.saveRound(round);
    }

    @DeleteMapping("/deleteRound/{id}")
    public String deleteRound(@PathVariable int id){

        return service.deletetRound(id);
    }
}
