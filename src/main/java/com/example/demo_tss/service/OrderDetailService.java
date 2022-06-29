package com.example.demo_tss.service;

import com.example.demo_tss.entity.OrderDetail;
import com.example.demo_tss.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional


public class OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;

    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        return repository.save(orderDetail);
    }

    public List<OrderDetail> saveOrderDetail(List<OrderDetail> orderDetails){
        return repository.saveAll(orderDetails);
    }
    public List<OrderDetail> getOrderDetail(){
        return repository.findAll();
    }
    public OrderDetail getOrderDetailById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<OrderDetail> getOrderDetailByOrderId(int orderId){

        return repository.findByOrderId(orderId);
    }

    public String deleteOrderDetail(int id){
        repository.deleteById(id);
        return "OrderDetail removed " + id;
    }
    public OrderDetail updateOrderDetail(OrderDetail orderDetail){
        OrderDetail existingOrderDetail= repository.findById(orderDetail.getId()).orElse(null);
        existingOrderDetail.setOrderId(orderDetail.getOrderId());
        existingOrderDetail.setTicketId(orderDetail.getTicketId());
        existingOrderDetail.setQuantity(orderDetail.getQuantity());
        return repository.save(existingOrderDetail);
    }
}
