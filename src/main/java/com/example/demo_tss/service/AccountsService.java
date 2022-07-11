package com.example.demo_tss.service;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.repository.AccountsRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountsService {
//dependency injection
    // Class Animal
    // Animal animal = new Animal
    // Bean
    // Start spring boot -> scan toàn bộ project -> @Service, @Repository, @Controller, @Componet,.. tạo thành bean bỏ trong context
    // @Autowire, constructor gọi (inject) bean ra và sử dụng
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
//    public List<Accounts> getAccountsByLastname(String lastname){
//
//        return repository.findByLastname(lastname);
//    }
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


    public int getAccountIdByUsername(String username){
         return repository.getAccountIdByUsername(username);
    }


}
