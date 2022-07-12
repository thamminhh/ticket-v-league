package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.repository.AccountsRepository;
import com.example.demo_tss.service.AccountsService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountsController {

    @Autowired
    private AccountsService service;
    @Autowired
    private AccountsRepository accountRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping("/login")
    public void checkLogin(String token) throws FirebaseAuthException {
        FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdToken(token);
        String userName = decoded.getName();
        System.out.println("USERNAME: " + userName);

    }

    @PostMapping
    public Accounts addAccount(@RequestBody Accounts accounts){

        return service.saveAccount(accounts);
    }


    @GetMapping (produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getAccounts(
            @RequestParam(required = false) String firstname,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Accounts> accounts = new ArrayList<Accounts>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Accounts> pageTuts;

            if (firstname == null)
                pageTuts = accountRepository.findAll(pagingSort);
            else
                pageTuts = accountRepository.findByFirstnameContaining(firstname, pagingSort);

            accounts = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("accounts", accounts);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Accounts findAccountByID(@PathVariable int id){
        return service.getAccountByID(id);
    }

//    @GetMapping("/{lastname}")
//    public List <Accounts> findAccountLastname(@PathVariable String lastname){
//        return service.getAccountsByLastname(lastname);
//    }

    @PutMapping
    public Accounts updateAccount(@RequestBody Accounts accounts){
        return service.saveAccount(accounts);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id){

        return service.deleteAccounts(id);
    }




}
