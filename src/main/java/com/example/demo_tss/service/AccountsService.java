package com.example.demo_tss.service;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountsService {

    @Autowired
    private AccountsRepository repository;

    public Accounts saveAccount(Accounts accounts){
        return repository.save(accounts);
    }

    public List<Accounts>  saveAccounts(List<Accounts> accounts){
        return repository.saveAll(accounts);
    }
    public List<Accounts> getAccounts(){
        return repository.findAll();
    }
    public Accounts getAccountByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Accounts> getAccountsByLastname(String lastname){

        return repository.findByLastname(lastname);
    }
    public String deleteAccounts(int id){
        repository.deleteById(id);
        return "Accounts removed " + id;
    }
    public Accounts updateAccount(Accounts account){
        Accounts existingAccount= repository.findById(account.getId()).orElse(null);
        existingAccount.setFirstname(account.getFirstname());
        existingAccount.setLastname(account.getLastname());
        existingAccount.setFirstname(account.getFirstname());
        existingAccount.setUsername(account.getUsername());
        existingAccount.setPassword(account.getPassword());
        return repository.save(existingAccount);
    }





}
