package com.example.demo_tss.controller;

import com.example.demo_tss.entity.SystemTicketType;
import com.example.demo_tss.service.SystemTicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/systemTicketType")
public class SystemTicketTypeController {
    @Autowired
    private SystemTicketTypeService service;

    @PostMapping()
    public SystemTicketType addSystemTicketType(@RequestBody SystemTicketType systemTicketType){
        return service.saveSystemTicketType(systemTicketType);
    }
    @GetMapping()
    public List<SystemTicketType> findAllSystemTicketType(){
        return service.getSystemTicketType();
    }

    @GetMapping("/{id}")
    public SystemTicketType findSystemTicketTypeByID(@PathVariable int id){
        return service.getSystemTicketTypeByID(id);
    }

//    @GetMapping("systemTicketTypeName/{systemTicketTypeName}")
//    public List <SystemTicketType> findSystemTicketTypeBySystemTicketTypeName(@PathVariable String systemTicketTypeName){
//        return service.getSystemTicketTypeBySystemTicketTypeName(systemTicketTypeName);
//    }

    @PutMapping()
    public SystemTicketType updateSystemTicketType(@RequestBody SystemTicketType systemTicketType){
        return service.saveSystemTicketType(systemTicketType);
    }

    @DeleteMapping("/{id}")
    public String deleteSystemTicketType(@PathVariable int id){

        return service.deleteSystemTicketType(id);
    }

}
