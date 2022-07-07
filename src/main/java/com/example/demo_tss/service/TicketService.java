package com.example.demo_tss.service;

import com.example.demo_tss.entity.Ticket;

import com.example.demo_tss.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional


public class TicketService {
    @Autowired
    private TicketRepository repository;

    public Ticket saveTicket(Ticket ticket){
        return repository.save(ticket);
    }

    public List<Ticket>  saveTicket(List<Ticket> ticket){
        return repository.saveAll(ticket);
    }
    public List<Ticket> getTicket(){
        return repository.findAll();
    }
    public Ticket getTicketByID(int id){
        return repository.findById(id).orElse(null);
    }
//    public List<Ticket> getTicketByTicketTypeId(int ticketTypeId){
//
//        return repository.findByTicketTypeId(ticketTypeId);
//    }
    public List<Ticket> getTicketByMatchId(int ticketTypeId){

        return repository.findByMatchId(ticketTypeId);
    }
    public String deleteTicket(int id){
        repository.deleteById(id);
        return "Ticket removed " + id;
    }
    public Ticket updateTicket(Ticket ticket){
        Ticket existingTicket= repository.findById(ticket.getId()).orElse(null);
        existingTicket.setMatchId(ticket.getMatchId());
        existingTicket.setAreaId(ticket.getAreaId());
        existingTicket.setPrice(ticket.getPrice());
        existingTicket.setAmount(ticket.getAmount());
        return repository.save(existingTicket);
    }

    public int getAmountByTicketId(int ticketId){
        int amount = repository.getAmountByTicketId(ticketId);
        return amount;
    }

    public void updateAmountTicketId(int newAmount, int ticketId){
         repository.updateAmountTicketId(newAmount, ticketId);
    }
}
