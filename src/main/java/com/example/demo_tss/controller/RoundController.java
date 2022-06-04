package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Round;
import com.example.demo_tss.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/round")
public class RoundController {
    @Autowired
    private RoundService service;

    @PostMapping()
    public Round addRound(@RequestBody Round round){
        return service.saveRound(round);
    }
    @GetMapping()
    public List<Round> findAllRound(){
        return service.getRound();
    }

    @GetMapping("/{id}")
    public Round findRoundByID(@PathVariable int id){
        return service.getRoundByID(id);
    }

    @GetMapping("tournamentId/{tournamentId}")
    public List <Round> findRoundByTournamentId(@PathVariable int tournamentId){
        return service.getRoundByTournamentId(tournamentId);
    }

    @PutMapping()
    public Round updateRound(@RequestBody Round round){
        return service.saveRound(round);
    }

    @DeleteMapping("/{id}")
    public String deleteRound(@PathVariable int id){

        return service.deletetRound(id);
    }
}
