package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Round;
import com.example.demo_tss.repository.RoundRepository;
import com.example.demo_tss.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/round")
public class RoundController {
    @Autowired
    private RoundService service;
    @Autowired
    private RoundRepository roundRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public Round addRound(@RequestBody Round round) {
        return service.saveRound(round);
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getRound(
            @RequestParam(required = false) String roundName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
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

            List<Round> rounds = new ArrayList<Round>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Round> pageTuts;

            if (roundName == null)
                pageTuts = roundRepository.findAll(pagingSort);
            else
                pageTuts = roundRepository.findByRoundNameContaining(roundName, pagingSort);

            rounds = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("rounds", rounds);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Round findRoundByID(@PathVariable int id) {
        return service.getRoundByID(id);
    }

    @GetMapping("tournamentId/{tournamentId}")
    public List<Round> findRoundByTournamentId(@PathVariable int tournamentId) {
        return service.getRoundByTournamentId(tournamentId);
    }

    @PutMapping()
    public Round updateRound(@RequestBody Round round) {
        return service.saveRound(round);
    }

    @DeleteMapping("/{id}")
    public String deleteRound(@PathVariable int id) {

        return service.deletetRound(id);
    }
}
