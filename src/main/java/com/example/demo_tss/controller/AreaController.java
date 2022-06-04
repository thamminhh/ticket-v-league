package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Area;
import com.example.demo_tss.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService service;

    @PostMapping()
    public Area addArea(@RequestBody Area area){
        return service.saveArea(area);
    }
    @GetMapping()
    public List<Area> findAllArea(){
        return service.getArea();
    }

    @GetMapping("/{id}")
    public Area findAreaByID(@PathVariable int id){
        return service.getAreaByID(id);
    }

    @GetMapping("/stadiumId/{stadiumId}")
    public List <Area> findAreaByStadiumId(@PathVariable int stadiumId){
        return service.getAreaByStadiumId(stadiumId);
    }

    @PutMapping()
    public Area updateArea(@RequestBody Area area){
        return service.saveArea(area);
    }

    @DeleteMapping("/{id}")
    public String deleteArea(@PathVariable int id){

        return service.deleteArea(id);
    }
}
