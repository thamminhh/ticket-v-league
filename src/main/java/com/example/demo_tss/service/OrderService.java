package com.example.demo_tss.service;

import com.example.demo_tss.entity.Order;
import com.example.demo_tss.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order){
        return repository.save(order);
    }

    public List<Order> saveOrder(List<Order> order){
        return repository.saveAll(order);
    }
        public List<Order> getOrder(){
        return repository.findAll();
    }
    public Order getOrderByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Order> getOrderByAccountId(int accountId){

        return repository.findByAccountId(accountId);
    }

    public String deleteOrder(int id){
        repository.deleteById(id);
        return "Order removed " + id;
    }
    public Order updateOrder(Order order){
        Order existingOrder= repository.findById(order.getId()).orElse(null);
        existingOrder.setAccountId(order.getAccountId());
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setTotal(order.getTotal());
        return repository.save(existingOrder);
    }
}
