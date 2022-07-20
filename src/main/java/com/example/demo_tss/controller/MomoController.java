package com.example.demo_tss.controller;

import com.example.demo_tss.entity.MoMoResponse;
import com.example.demo_tss.repository.OrderRepository;
import com.example.demo_tss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")

public class MomoController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/momo")
    public void getMomoResponse(@RequestBody MoMoResponse moMoResponse){
        System.out.println("IAM HERE");
        int orderId = moMoResponse.getOrderId();
        int resultCode = moMoResponse.getResultCode();

        if(resultCode == 0){
            orderService.updateOrderStatus(resultCode, orderId);
        }
    }


}
