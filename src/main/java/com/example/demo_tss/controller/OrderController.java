package com.example.demo_tss.controller;

import com.example.demo_tss.entity.CartInfo;
import com.example.demo_tss.entity.Order;
import com.example.demo_tss.repository.OrderRepository;
import com.example.demo_tss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;

    @PostMapping()
    public void addOrder(@RequestBody CartInfo cartInfo){
        service.saveOrder(cartInfo);
    }
    @GetMapping()
    public List<Order> findAllOrder(){
        return service.getOrder();
    }

    @GetMapping("/{id}")
    public Order findOrderByID(@PathVariable int id){
        return service.getOrderByID(id);
    }


    @GetMapping("acountId/{accountId}")
    public List <Order> findOrdertByAccountId(@PathVariable int accountId){
        return service.getOrderByAccountId(accountId);
    }

//    @PutMapping("")
//    public Order updateOrder(@RequestBody Order order){
//        return service.saveOrder(order);
//    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id){

        return service.deleteOrder(id);
    }

//    @GetMapping("/maxId")
//    public int getOrderIdMax(){
//        int orderId = repository.getNewestOrderId();
//        System.out.println(orderId);
//        return orderId;
//    }
}
