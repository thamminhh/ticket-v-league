package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Club;
import com.example.demo_tss.repository.ClubRepository;
import com.example.demo_tss.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/club")

public class ClubController {
    @Autowired
    private ClubService service;

    @Autowired
    private ClubRepository clubRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
    @PostMapping()
    public Club addClub(@RequestBody Club club){
        return service.saveClub(club);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getClubs(
            @RequestParam(required = false) String clubName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Club> clubs = new ArrayList<Club>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Club> pageTuts;

            if (clubName == null)
                pageTuts = clubRepository.findAll(pagingSort);
            else
                pageTuts = clubRepository.findByClubNameContaining(clubName, pagingSort);

            clubs = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("clubs", clubs);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Club findClubByID(@PathVariable int id){
        return service.getClubByID(id);
    }

    @GetMapping("/stadiumId/{stadiumId}")
    public List <Club> findClubByStadiumId(@PathVariable int stadiumId){
        return service.getClubByStadiumId(stadiumId);
    }

    @PutMapping()
    public Club updateClub(@RequestBody Club club){
        return service.saveClub(club);
    }

    @DeleteMapping("/{id}")
    public String deleteClub(@PathVariable int id){

        return service.deleteClub(id);
    }
}
