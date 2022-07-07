package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
//    List<Ticket> findByTicketTypeId(int ticketTypeId);

    List<Ticket> findByMatchId(int ticketTypeId);

    @Query(value = "select amount from ticket where Id = ?", nativeQuery = true)
    int getAmountByTicketId(int ticketId);

    @Modifying
    @Query(value = "update ticket set amount = ? where Id = ?", nativeQuery = true)
    void updateAmountTicketId(int newAmount, int ticketId);
}
