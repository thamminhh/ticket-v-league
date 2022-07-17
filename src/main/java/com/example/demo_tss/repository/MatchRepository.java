package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByStadiumId(int stadiumId);

    List<Match> findByClubHomeId(int clubHomeId);

    List<Match> findByClubVisitorId(int clubVisitorId);

    @Query(value = "select m.id, m.roundId, m.stadiumId, m.clubHomeId, m.clubVisitorId, m.timeStart,m.status, s.id, s.stadiumName, s.location, s.capacity, s.img,\n" +
            "c.id, c.stadiumId, c.clubName, c.img, c.country,\n" +
            "c1.id, c1.stadiumId, c1.clubName, c1.img, c1.country " +
            "from matches m inner join \n" +
            "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
            "inner join club c1 on m.clubVisitorId = c1.id where m.status = '1'",
            countQuery = "select count(*) from matches m inner join \n" +
                    "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
                    "inner join club c1 on m.clubVisitorId = c1.id where m.status = '1' order by m.id;",
            nativeQuery = true)
    Page<Match> findAllInfo(Pageable pagingSort);

    List<Match> findByRoundId(int roundId);
}
