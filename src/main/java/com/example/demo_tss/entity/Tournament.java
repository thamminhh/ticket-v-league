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
@Table(name = "tournament")

public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tournamentName;
    private String startDate;
    private String endDate;
    private boolean status;
//    @OneToMany(targetEntity = Round.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name ="tournamentId", referencedColumnName = "id")
////    @JsonIgnore
//    private List<Round> rounds;

}
