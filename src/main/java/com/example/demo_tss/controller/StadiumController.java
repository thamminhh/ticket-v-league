package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Stadium;
import com.example.demo_tss.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StadiumController {
    @Autowired
    private StadiumService service;

    @PostMapping("/addStadium")
    public Stadium addStadium(@RequestBody Stadium stadium){
        return service.saveStadium(stadium);
    }
    @GetMapping("/getStadiums")
    public List<Stadium> findAllStadium(){
        return service.getStadium();
    }

    @GetMapping("/getStadiumById/{id}")
    public Stadium findStadiumByID(@PathVariable int id){
        return service.getStadiumByID(id);
    }

    @GetMapping("getStadiumsByStadiumName/{stadiumName}")
    public List <Stadium> findStadiumByName(@PathVariable String stadiumName){
        return service.getStadiumByStadiumName(stadiumName);
    }

    @PutMapping("/updateStadium")
    public Stadium updateStadium(@RequestBody Stadium stadium){
        return service.saveStadium(stadium);
    }

    @DeleteMapping("/deleteStadium/{id}")
    public String deteleStadium(@PathVariable int id){

        return service.deleteStadium(id);
    }
}
