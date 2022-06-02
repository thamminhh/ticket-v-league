package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Club;
import com.example.demo_tss.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ClubController {
    @Autowired
    private ClubService service;

    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club club){
        return service.saveClub(club);
    }
    @GetMapping("/getClubs")
    public List<Club> findAllArea(){
        return service.getClub();
    }

    @GetMapping("/getClubById/{id}")
    public Club findClubByID(@PathVariable int id){
        return service.getClubByID(id);
    }

    @GetMapping("getClubByStadiumId/{stadiumId}")
    public List <Club> findClubByStadiumId(@PathVariable int stadiumId){
        return service.getClubByStadiumId(stadiumId);
    }

    @PutMapping("/updateClub")
    public Club updateClub(@RequestBody Club club){
        return service.saveClub(club);
    }

    @DeleteMapping("/deleteClub/{id}")
    public String deleteClub(@PathVariable int id){

        return service.deleteClub(id);
    }
}
