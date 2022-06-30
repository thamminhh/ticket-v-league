package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int matchId;
    private int areaId;
    @ManyToOne( targetEntity = Area.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="areaId", referencedColumnName = "id", insertable = false, updatable = false)
    private Area area;
    private double price;
    private int amount;

}
