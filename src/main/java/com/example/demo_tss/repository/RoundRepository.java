package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer>  {
    List<Round> findByTournamentId(final int tournamentId);
}
