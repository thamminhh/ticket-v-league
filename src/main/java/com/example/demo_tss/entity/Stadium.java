package com.example.demo_tss.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @OneToMany(targetEntity = Match.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name ="stadiumId", referencedColumnName = "id")
//    @JsonIgnore
//    private List<Match> matches;
}
