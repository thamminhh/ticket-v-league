package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Round;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer>  {
    List<Round> findByTournamentId(final int tournamentId);

    Page<Round> findByRoundNameContaining(String roundName, Pageable pagingSort);

}
