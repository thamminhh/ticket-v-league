package com.example.demo_tss.repository;
import com.example.demo_tss.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {

    List<Stadium> findByStadiumName(String stadiumName);
}

