package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "area")

public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String areaName;
    private int stadiumId;
    private int capacity;
    private int ticketTypeId;
    @ManyToOne( targetEntity = TicketType.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="ticketTypeId", referencedColumnName = "id", insertable = false, updatable = false)
    private TicketType ticketType;
}
