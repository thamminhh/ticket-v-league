package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    List<Accounts> findByLastname( final String lastname);

}
