package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentMethodRepository  extends JpaRepository<PaymentMethod, Integer> {
}
