package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "round")

public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tournamentId;
    @ManyToOne(targetEntity = Tournament.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="tournamentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Tournament tournament;
    private String roundName;
    private String startDate;
    private String endDate;
    private boolean status;
}
