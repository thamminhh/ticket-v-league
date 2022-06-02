package com.example.demo_tss.repository;

import com.example.demo_tss.entity.SystemTicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SystemTicketTypeRepository extends JpaRepository<SystemTicketType, Integer>{

    List<SystemTicketType> findBySystemTicketTypeName(String systemTicketTypeName);
}
