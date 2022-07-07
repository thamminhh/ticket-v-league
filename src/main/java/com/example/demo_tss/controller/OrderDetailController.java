package com.example.demo_tss.controller;



import com.example.demo_tss.entity.OrderDetail;
import com.example.demo_tss.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")

public class OrderDetailController {
    @Autowired
    private OrderDetailService service;

    @PostMapping()
    public List<OrderDetail> addOrder(@RequestBody List<OrderDetail> orderDetail){

        return service.saveOrderDetail(orderDetail);
    }
    @GetMapping()
    public List<OrderDetail> findAllOrderDetail(){
        return service.getOrderDetail();
    }

    @GetMapping("/{id}")
    public OrderDetail findOrderDetailByID(@PathVariable int id){
        return service.getOrderDetailById(id);
    }


    @GetMapping("orderId/{orderId}")
    public List <OrderDetail> findOrderDetailtByOrderId(@PathVariable int orderId){
        return service.getOrderDetailByOrderId(orderId);
    }

    @PutMapping("")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail){
        return service.saveOrderDetail(orderDetail);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderDetail(@PathVariable int id){

        return service.deleteOrderDetail(id);
    }

}
