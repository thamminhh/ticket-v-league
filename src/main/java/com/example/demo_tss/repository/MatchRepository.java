package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByStadiumId(int stadiumId);

    List<Match> findByClubHomeId(int clubHomeId);

    List<Match> findByClubVisitorId(int clubVisitorId);
}
