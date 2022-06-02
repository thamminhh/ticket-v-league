package com.example.demo_tss.controller;

import com.example.demo_tss.entity.TicketType;
import com.example.demo_tss.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TicketTypeController {

    @Autowired
    private TicketTypeService service;

    @PostMapping("/addTicketType")
    public TicketType addTicketType(@RequestBody TicketType ticketType){
        return service.saveTicketType(ticketType);
    }
    @GetMapping("/getTicketTypes")
    public List<TicketType> findAllTicketType(){
        return service.getTicketType();
    }

    @GetMapping("/getTicketTypeById/{id}")
    public TicketType findTicketTypeByID(@PathVariable int id){
        return service.getTicketTypeByID(id);
    }

    @GetMapping("getTicketTypeSystemTicketTypeId/{systemTicketTypeId}")
    public List <TicketType> findTicketTypeBySystemTicketTypeId(@PathVariable int systemTicketTypeId){
        return service.getTicketTypeBySystemTicketTypeId(systemTicketTypeId);
    }

    @PutMapping("/updateTicketType")
    public TicketType updateTicketType(@RequestBody TicketType ticketType){
        return service.saveTicketType(ticketType);
    }

    @DeleteMapping("/deleteTicketType/{id}")
    public String deleteTicketType(@PathVariable int id){
        return service.deleteTicketType(id);
    }

}
