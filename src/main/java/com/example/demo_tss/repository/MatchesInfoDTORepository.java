//package com.example.demo_tss.repository;
//
//import com.example.demo_tss.entity.Match;
//import com.example.demo_tss.entity.MatchesInfoDTO;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MatchesInfoDTORepository  extends JpaRepository<MatchesInfoDTORepository, Integer> {
//
//    @Query(value = "select * from matchs m inner join \n" +
//            "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
//            "inner join club c1 on m.clubVisitorId = c1.id ",
//            countQuery = "select count(*) from matchs m inner join \n" +
//                    "stadium s on m.stadiumId = s.id  inner join club c on m.clubHomeId = c.id \n" +
//                    "inner join club c1 on m.clubVisitorId = c1.id order by m.id;",
//            nativeQuery = true)
//    Page<MatchesInfoDTO> findAllInfo(Pageable pagingSort);
//}
