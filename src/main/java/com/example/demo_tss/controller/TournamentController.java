package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Tournament;
import com.example.demo_tss.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @PostMapping()
    public Tournament addTournament(@RequestBody Tournament tournament){
        return service.saveTournament(tournament);
    }
    @GetMapping()
    public List<Tournament> findAllTournament(){
        return service.getTournaments();
    }

    @GetMapping("/{id}")
    public Tournament findTournamentByID(@PathVariable int id){
        return service.getTournamentByID(id);
    }

//    @GetMapping("getTournamentByName/{tournamentName}")
//    public List <Tournament> findTournamentName(@PathVariable String tournamentName){
//        return service.getTournamentName(tournamentName);
//    }

    @PutMapping()
    public Tournament updateTournament(@RequestBody Tournament tournament){
        return service.updateTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public String deleteTournament(@PathVariable int id){
        return service.deleteTournament(id);
    }



}
