package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClubRepository extends JpaRepository<Club, Integer>{
    List<Club> findByStadiumId(int stadiumId);

    Page<Club> findByClubNameContaining(String clubName, Pageable pagingSort);
}
