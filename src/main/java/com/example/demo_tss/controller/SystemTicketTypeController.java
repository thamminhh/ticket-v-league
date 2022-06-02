package com.example.demo_tss.controller;

import com.example.demo_tss.entity.SystemTicketType;
import com.example.demo_tss.service.SystemTicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class SystemTicketTypeController {
    @Autowired
    private SystemTicketTypeService service;

    @PostMapping("/addSystemTicketType")
    public SystemTicketType addSystemTicketType(@RequestBody SystemTicketType systemTicketType){
        return service.saveSystemTicketType(systemTicketType);
    }
    @GetMapping("/getSystemTicketTypes")
    public List<SystemTicketType> findAllSystemTicketType(){
        return service.getSystemTicketType();
    }

    @GetMapping("/getSystemTicketTypeById/{id}")
    public SystemTicketType findSystemTicketTypeByID(@PathVariable int id){
        return service.getSystemTicketTypeByID(id);
    }

    @GetMapping("getSystemTicketTypeBySystemTicketTypeName/{systemTicketTypeName}")
    public List <SystemTicketType> findSystemTicketTypeBySystemTicketTypeName(@PathVariable String systemTicketTypeName){
        return service.getSystemTicketTypeBySystemTicketTypeName(systemTicketTypeName);
    }

    @PutMapping("/updateSystemTicketType")
    public SystemTicketType updateSystemTicketType(@RequestBody SystemTicketType systemTicketType){
        return service.saveSystemTicketType(systemTicketType);
    }

    @DeleteMapping("/deleteSystemTicketType/{id}")
    public String deletedeleteArea(@PathVariable int id){

        return service.deleteSystemTicketType(id);
    }

}
