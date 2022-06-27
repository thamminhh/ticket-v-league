package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Round;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer>  {
    List<Round> findByTournamentId(final int tournamentId);



@Query(value = "select r.id, r.tournamentId, r.roundName, r.startDate, r.endDate, r.status,\n" +
            "t.id, t.tournamentName, t.startDate, t.endDate \n" +
            "from round r inner join tournament t on r.tournamentId = t.id where r.status ='1'",
            countQuery = "select count(*) from round r inner join tournament t on r.tournamentId = t.id where r.status ='1' order by r.id ",
            nativeQuery = true)
    Page<Round> findByRoundNameContaining(String roundName, Pageable pagingSort);
}
