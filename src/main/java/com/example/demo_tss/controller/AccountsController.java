package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountsController {

    @Autowired
    private AccountsService service;

    @PostMapping
    public Accounts addAccount(@RequestBody Accounts accounts){
        return service.saveAccount(accounts);
    }
    @GetMapping
    public List<Accounts> findAllAccounts(){
        // spring boot Criteria / specification
        return service.getAccounts();
    }

    @GetMapping("/{id}")
    public Accounts findAccountByID(@PathVariable int id){
        return service.getAccountByID(id);
    }

    @GetMapping("/{lastname}")
    public List <Accounts> findAccountLastname(@PathVariable String lastname){
        return service.getAccountsByLastname(lastname);
    }

    @PutMapping
    public Accounts updateAccount(@RequestBody Accounts accounts){
        return service.saveAccount(accounts);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id){

        return service.deleteAccounts(id);
    }


}
