//package com.example.demo_tss.controller;
//
//import com.example.demo_tss.entity.TicketType;
//import com.example.demo_tss.service.TicketTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/ticketType")
//
//public class TicketTypeController {
//
//    @Autowired
//    private TicketTypeService service;
//
//    @PostMapping()
//    public TicketType addTicketType(@RequestBody TicketType ticketType){
//        return service.saveTicketType(ticketType);
//    }
//    @GetMapping()
//    public List<TicketType> findAllTicketType(){
//        return service.getTicketType();
//    }
//
//    @GetMapping("/{id}")
//    public TicketType findTicketTypeByID(@PathVariable int id){
//        return service.getTicketTypeByID(id);
//    }
//
//    @GetMapping("systemTicketTypeId/{systemTicketTypeId}")
//    public List <TicketType> findTicketTypeBySystemTicketTypeId(@PathVariable int systemTicketTypeId){
//        return service.getTicketTypeBySystemTicketTypeId(systemTicketTypeId);
//    }
//
//    @PutMapping()
//    public TicketType updateTicketType(@RequestBody TicketType ticketType){
//        return service.saveTicketType(ticketType);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteTicketType(@PathVariable int id){
//        return service.deleteTicketType(id);
//    }
//
//}
