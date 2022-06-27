package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Query(value = "select t.id, t.tournamentName, t.startDate, t.endDate, t.status from tournament t where status = '1'",
            countQuery = "select count(*) from tournament t where status ='1' ",
            nativeQuery = true)
    Page<Tournament> findByTournamentNameContaining(String tournamentName, Pageable pagingSort);
    @Query(value = "select t.id, t.tournamentName, t.startDate, t.endDate, t.status from tournament t where status = '1'",
            countQuery = "select count(*) from tournament t where status ='1' ",
            nativeQuery = true)
    Page<Tournament> findAllStatusActive(Pageable pagingSort);
}
