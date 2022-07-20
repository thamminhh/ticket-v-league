package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.repository.MatchRepository;
import com.example.demo_tss.service.MatchService;
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
@RequestMapping("/match")

public class MatchController {

    @Autowired
    private MatchService service;

    @Autowired
    private MatchRepository matchRepository;


    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public Match addMatch(@RequestBody Match match){
        return service.saveMatch(match);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getMatches(
//            Pageable pageable
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

            List<Match> matches = new ArrayList<Match>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Match> pageTuts;

                pageTuts = matchRepository.findAllInfo(pagingSort);

            matches = pageTuts.getContent();
            System.out.println(matches);

            System.out.println("IAM HERE");
            Map<String, Object> response = new HashMap<>();
            response.put("matches", matches);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Match findMatchByID(@PathVariable int id){
        return service.getMatchByID(id);
    }

    @GetMapping("stadiumId/{stadiumId}")
    public List <Match> findMatchByStadiumId(@PathVariable int stadiumId){
        return service.getMatchByStadiumId(stadiumId);
    }
    @GetMapping("roundId/{roundId}")
    public List <Match> findMatchByRoundId(@PathVariable int roundId){
        return service.getMatchByRoundId(roundId);
    }
    @GetMapping("clubHomeId/{clubHomeId}")
    public List <Match> findMatchByClubHomeId(@PathVariable int clubHomeId){
        return service.getMatchByClubHomeId(clubHomeId);
    }
    @GetMapping("clubVisitorId/{clubVisitorId}")
    public List <Match> findMatchByClubVisitorId(@PathVariable int clubVisitorId){
        return service.getMatchByClubVisitorId(clubVisitorId);
    }
    @PutMapping()
    public Match updateMatch(@RequestBody Match match){
        return service.saveMatch(match);
    }

    @DeleteMapping("/{id}")
    public String deleteMatch(@PathVariable int id){

        return service.deleteMatch(id);
    }
}
