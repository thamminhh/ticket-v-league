package com.example.demo_tss.service;


import com.example.demo_tss.entity.PaymentMethod;
import com.example.demo_tss.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository repository;

    public PaymentMethod savePaymentMethod(PaymentMethod payments){
        return repository.save(payments);
    }

    public List<PaymentMethod> savePaymentMethod(List<PaymentMethod> payments){
        return repository.saveAll(payments);
    }
    public List<PaymentMethod> getPaymentMethod(){

        return repository.findAll();
    }
    public PaymentMethod getPaymentMethodByID(int id){
        return repository.findById(id).orElse(null);
    }
    //    public List<Accounts> getAccountsByLastname(String lastname){
//
//        return repository.findByLastname(lastname);
//    }
    public String deletePaymentMethods(int id){
        repository.deleteById(id);
        return "PaymentMethod removed " + id;
    }
    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod){
        PaymentMethod existingPaymentMethod= repository.findById(paymentMethod.getId()).orElse(null);
        existingPaymentMethod.setPaymentMethodName(paymentMethod.getPaymentMethodName());
        return repository.save(existingPaymentMethod);
    }
}
