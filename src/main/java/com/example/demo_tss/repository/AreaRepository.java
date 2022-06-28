package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AreaRepository extends JpaRepository<Area, Integer>  {
    List<Area> findByStadiumId(int stadiumId);

    @Query(value = "select a.id, a.stadiumId, a.areaName, a.capacity, a.ticketTypeId, t.id, t.systemTicketTypeId, t.ticketTypeName, t.price, t.amount from area a \n" +
            "inner join stadium s on a.stadiumId = s.id \n" +
            "inner join ticketType t on t.id = a.ticketTypeId",
            countQuery = "select count(*) from area a \n" +
                    "inner join stadium s on a.stadiumId = s.id \n" +
                    "inner join ticketType t on t.id = a.ticketTypeId order by a.id;",
            nativeQuery = true)
    Page<Area> findAllInfo(Pageable pagingSort);

//    Page<Area> findAllInfo(Pageable pagingSort);
}
