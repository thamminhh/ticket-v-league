package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    private AccountsService service;

    @PostMapping("/addAccount")
    public Accounts addAccount(@RequestBody Accounts accounts){
        return service.saveAccount(accounts);
    }
    @GetMapping("/getAccounts")
    public List<Accounts> findAllAccounts(){
        return service.getAccounts();
    }

    @GetMapping("/getAccountById/{id}")
    public Accounts findAccountByID(@PathVariable int id){
        return service.getAccountByID(id);
    }

    @GetMapping("getAccountsByLastname/{lastname}")
    public List <Accounts> findAccountLastname(@PathVariable String lastname){
        return service.getAccountsByLastname(lastname);
    }

    @PutMapping("/updateAccount")
    public Accounts updateAccount(@RequestBody Accounts accounts){
        return service.saveAccount(accounts);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id){

        return service.deleteAccounts(id);
    }


}
