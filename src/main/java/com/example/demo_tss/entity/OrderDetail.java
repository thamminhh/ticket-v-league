package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderDetail")


public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    private int ticketId;
    @ManyToOne( targetEntity = Ticket.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="ticketId", referencedColumnName = "id", insertable = false, updatable = false)
    private Ticket ticket ;
    private int quantity;
}
