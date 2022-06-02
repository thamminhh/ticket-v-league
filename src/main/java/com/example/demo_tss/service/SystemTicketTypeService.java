package com.example.demo_tss.service;

import com.example.demo_tss.entity.SystemTicketType;
import com.example.demo_tss.repository.SystemTicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class SystemTicketTypeService {
    @Autowired
    private SystemTicketTypeRepository repository;

    public SystemTicketType saveSystemTicketType(SystemTicketType systemTicketType){
        return repository.save(systemTicketType);
    }

    public List<SystemTicketType>  saveSystemTicketType(List<SystemTicketType> systemTicketType){
        return repository.saveAll(systemTicketType);
    }
    public List<SystemTicketType> getSystemTicketType(){
        return repository.findAll();
    }
    public SystemTicketType getSystemTicketTypeByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<SystemTicketType> getSystemTicketTypeBySystemTicketTypeName(String systemTicketTypeName){

        return repository.findBySystemTicketTypeName((systemTicketTypeName));
    }
    public String deleteSystemTicketType(int id){
        repository.deleteById(id);
        return "SystemTicketType removed " + id;
    }
    public SystemTicketType updateSystemTicketType(SystemTicketType systemTicketType){
        SystemTicketType existingSystemTicketType= repository.findById(systemTicketType.getId()).orElse(null);
        existingSystemTicketType.setSystemTicketTypeName(systemTicketType.getSystemTicketTypeName());
        return repository.save(existingSystemTicketType);
    }
}
