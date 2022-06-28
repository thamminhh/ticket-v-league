package com.example.demo_tss.controller;

import com.example.demo_tss.entity.PaymentMethod;
import com.example.demo_tss.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/paymentMethod")

public class PaymentMethodController {

    @Autowired
    private PaymentMethodService service;

    @PostMapping()
    public PaymentMethod addPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        return service.savePaymentMethod(paymentMethod);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public List<PaymentMethod> findAllPaymentMethod(){
        return service.getPaymentMethod();
    }

    @GetMapping("/{id}")
    public PaymentMethod findPaymentMethodByID(@PathVariable int id){
        return service.getPaymentMethodByID(id);
    }

    @PutMapping()
    public PaymentMethod updatePaymentMethod(@RequestBody PaymentMethod paymentMethod){
        return service.savePaymentMethod(paymentMethod);
    }

    @DeleteMapping("/{id}")
    public String deletePaymentMethod(@PathVariable int id){
        return service.deletePaymentMethods(id);
    }
}

