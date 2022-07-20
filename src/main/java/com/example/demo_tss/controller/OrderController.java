package com.example.demo_tss.controller;

import com.example.demo_tss.entity.CartInfo;
import com.example.demo_tss.entity.CartLineInfo;
import com.example.demo_tss.entity.Match;
import com.example.demo_tss.entity.Order;
import com.example.demo_tss.repository.OrderRepository;
import com.example.demo_tss.service.OrderService;
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

@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public void addOrder(@RequestBody CartInfo cartInfo){
        for (CartLineInfo line:
             cartInfo.getCartLines()) {
            System.out.println(line.getTicketId());
        }
        service.saveOrder(cartInfo);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getOrdereds(
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

            List<Order> orderList = new ArrayList<Order>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Order> pageTuts;

            pageTuts = repository.findOrderedInfo(pagingSort);

            orderList = pageTuts.getContent();


            Map<String, Object> response = new HashMap<>();
            response.put("orderList", orderList);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all", produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getOrders(
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

            List<Order> orderList = new ArrayList<Order>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Order> pageTuts;

            pageTuts = repository.findOrderInfo(pagingSort);

            orderList = pageTuts.getContent();


            Map<String, Object> response = new HashMap<>();
            response.put("orderList", orderList);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Order findOrderByID(@PathVariable int id){
        return service.getOrderByID(id);
    }


    @GetMapping("username/{username}")
    public List <Order> findOrderByAccountId(@PathVariable String username){
        return service.getOrderByUsername(username);
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
