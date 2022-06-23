package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stadiumName;
    private String location;
    private String capacity;
    private String img;
//    @OneToMany(targetEntity = Match.class, cascade = CascadeType.ALL)
//    @JoinColumn(name ="stadiumId", referencedColumnName = "id")
//    private List<Match> matches;
}
