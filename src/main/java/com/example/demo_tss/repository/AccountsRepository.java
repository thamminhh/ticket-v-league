package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    Page<Accounts> findByFirstnameContaining(String firstname, Pageable pagingSort);

    @Query(value = "select id from accounts where username = ?", nativeQuery = true)
    int getAccountIdByUsername(String username);

}
