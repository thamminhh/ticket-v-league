package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.entity.MatchesInfoDTO;
import io.swagger.models.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.net.http.HttpResponse;
import java.util.List;

@Repository

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByStadiumId(int stadiumId);

    List<Match> findByClubHomeId(int clubHomeId);

    List<Match> findByClubVisitorId(int clubVisitorId);

    @Query(value = "select * from matches m inner join \n" +
            "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
            "inner join club c1 on m.clubVisitorId = c1.id",
            countQuery = "select count(*) from matches m inner join \n" +
                    "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
                    "inner join club c1 on m.clubVisitorId = c1.id order by m.id;",
            nativeQuery = true)
    Page<Match> findAllInfo(Pageable pagingSort);
}
