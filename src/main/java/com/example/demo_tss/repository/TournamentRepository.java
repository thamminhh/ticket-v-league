package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    Page<Tournament> findByTournamentNameContaining(String tournamentName, Pageable pagingSort);
}
