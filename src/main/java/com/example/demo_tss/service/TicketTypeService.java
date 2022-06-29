//package com.example.demo_tss.service;
//
//import com.example.demo_tss.entity.TicketType;
//import com.example.demo_tss.repository.TicketTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Transactional
//
//public class TicketTypeService {
//
//    @Autowired
//    private TicketTypeRepository repository;
//
//    public TicketType saveTicketType(TicketType ticketType){
//        return repository.save(ticketType);
//    }
//
//    public List<TicketType>  saveTicketType(List<TicketType> ticketType){
//        return repository.saveAll(ticketType);
//    }
//    public List<TicketType> getTicketType(){
//        return repository.findAll();
//    }
//    public TicketType getTicketTypeByID(int id){
//        return repository.findById(id).orElse(null);
//    }
//    public List<TicketType> getTicketTypeBySystemTicketTypeId(int systemTicketTypeId){
//
//        return repository.findBySystemTicketTypeId((systemTicketTypeId));
//    }
//    public String deleteTicketType(int id){
//        repository.deleteById(id);
//        return "TicketType removed " + id;
//    }
//    public TicketType updateTicketType(TicketType ticketType){
//        TicketType existingTicketType= repository.findById(ticketType.getId()).orElse(null);
//        existingTicketType.setSystemTicketTypeId(ticketType.getSystemTicketTypeId());
//        existingTicketType.setTicketTypeName(ticketType.getTicketTypeName());
//        existingTicketType.setPrice(ticketType.getPrice());
//        return repository.save(existingTicketType);
//    }
//
//}
