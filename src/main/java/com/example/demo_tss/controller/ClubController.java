package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Club;
import com.example.demo_tss.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")

public class ClubController {
    @Autowired
    private ClubService service;

    @PostMapping()
    public Club addClub(@RequestBody Club club){
        return service.saveClub(club);
    }
    @GetMapping()
    public List<Club> findAllArea(){
        return service.getClub();
    }

    @GetMapping("/{id}")
    public Club findClubByID(@PathVariable int id){
        return service.getClubByID(id);
    }

    @GetMapping("/stadiumId/{stadiumId}")
    public List <Club> findClubByStadiumId(@PathVariable int stadiumId){
        return service.getClubByStadiumId(stadiumId);
    }

    @PutMapping()
    public Club updateClub(@RequestBody Club club){
        return service.saveClub(club);
    }

    @DeleteMapping("/{id}")
    public String deleteClub(@PathVariable int id){

        return service.deleteClub(id);
    }
}
