package com.example.demo_tss.service;

import com.example.demo_tss.entity.CartInfo;
import com.example.demo_tss.entity.CartLineInfo;
import com.example.demo_tss.entity.Order;
import com.example.demo_tss.entity.OrderDetail;
import com.example.demo_tss.repository.OrderDetailRepository;
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
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private AccountsService accountsServices;

    public String saveOrder(CartInfo cartInfo) {
        String message = "Success order";
        Order order = new Order();
        int defaultStatus = 1;

        int accountId = accountsServices.getAccountIdByUsername(cartInfo.getUserName());
        order.setAccountId(accountId);
        order.setTotal(cartInfo.getTotal());
        order.setOrderDate(cartInfo.getOrderDate());
        order.setStatus(defaultStatus);

        repository.save(order);

        int orderId = getNewestOrderId();

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines
        ) {
            int ticketId = line.getTicketId();
            int quantity = line.getQuantity();
            int ticketAmount = ticketService.getAmountByTicketId(ticketId);
            int newAmount = ticketAmount - quantity;
            System.out.println(newAmount);
            if(newAmount < 0 ){
                return message = "Out of ticket";
            }
            else {
                ticketService.updateAmountTicketId(newAmount,ticketId);
                OrderDetail detail = new OrderDetail();
                detail.setOrderId(orderId);
                detail.setTicketId(ticketId);
                detail.setQuantity(quantity);
                orderDetailRepository.save(detail);
            }
        }
        return message;
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
    public List<Order> getOrderByUsername (String username){
        int accountId = accountsServices.getAccountIdByUsername(username);
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

    public int getNewestOrderId(){
        int orderId = repository.getNewestOrderId();
        return orderId;
    }

    public void updateOrderStatus(int status, int orderId){
        repository.updateOrderStatus(status, orderId);
    }
}
