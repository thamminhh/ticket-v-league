package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAccountId(int accountId);

    @Query(value = "select MAX(id) from orders", nativeQuery = true)
    int getNewestOrderId();
}
