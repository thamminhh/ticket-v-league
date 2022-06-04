package com.example.demo_tss.controller;


import com.example.demo_tss.entity.Ticket;

import com.example.demo_tss.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")

public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping()
    public Ticket addTicket(@RequestBody Ticket ticket){
        return service.saveTicket(ticket);
    }
    @GetMapping()
    public List<Ticket> findAllTicket(){
        return service.getTicket();
    }

    @GetMapping("/{id}")
    public Ticket findTicketByID(@PathVariable int id){
        return service.getTicketByID(id);
    }

    @GetMapping("ticketTypeId/{ticketTypeId}")
    public List <Ticket> findAreaByStadiumId(@PathVariable int ticketTypeId){
        return service.getTicketByTicketTypeId(ticketTypeId);
    }

    @GetMapping("matchId/{matchId}")
    public List <Ticket> findTicketByMatchId(@PathVariable int matchId){
        return service.getTicketByMatchId(matchId);
    }

    @PutMapping("")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return service.saveTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable int id){

        return service.deleteTicket(id);
    }

}
