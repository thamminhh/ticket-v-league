package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matches")

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roundId;
    private int stadiumId;
    @ManyToOne( targetEntity = Stadium.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="stadiumId", referencedColumnName = "id", insertable = false, updatable = false)
    private Stadium stadium;
    private int clubHomeId;
    @ManyToOne(targetEntity = Club.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="clubHomeId", referencedColumnName = "id", insertable = false, updatable = false)
    private Club clubHome;
    private int clubVisitorId;
    @ManyToOne(targetEntity = Club.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="clubVisitorId", referencedColumnName = "id", insertable = false, updatable = false)
    private Club clubVisitor;
    private String timeStart;
    private boolean status;

}
