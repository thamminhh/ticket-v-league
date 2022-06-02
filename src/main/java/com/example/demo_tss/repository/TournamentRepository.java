package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    List<Tournament> findByTournamentName(String tournamentName);
}
