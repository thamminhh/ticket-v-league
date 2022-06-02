package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Area;
import com.example.demo_tss.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AreaController {
    @Autowired
    private AreaService service;

    @PostMapping("/addArea")
    public Area addArea(@RequestBody Area area){
        return service.saveArea(area);
    }
    @GetMapping("/getAreas")
    public List<Area> findAllArea(){
        return service.getArea();
    }

    @GetMapping("/getAreaById/{id}")
    public Area findAreaByID(@PathVariable int id){
        return service.getAreaByID(id);
    }

    @GetMapping("getAreaByStadiumId/{stadiumId}")
    public List <Area> findAreaByStadiumId(@PathVariable int stadiumId){
        return service.getAreaByStadiumId(stadiumId);
    }

    @PutMapping("/updateArea")
    public Area updateArea(@RequestBody Area area){
        return service.saveArea(area);
    }

    @DeleteMapping("/deleteArea/{id}")
    public String deleteArea(@PathVariable int id){

        return service.deleteArea(id);
    }
}
