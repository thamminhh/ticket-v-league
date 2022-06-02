package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AreaRepository extends JpaRepository<Area, Integer>  {
    List<Area> findByStadiumId(int stadiumId);
}
