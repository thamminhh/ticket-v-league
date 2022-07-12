package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Tournament;
import com.example.demo_tss.repository.TournamentRepository;
import com.example.demo_tss.service.TournamentService;
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
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService service;
    @Autowired
    private TournamentRepository tournamentRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public Tournament addTournament(@RequestBody Tournament tournament){
        return service.saveTournament(tournament);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getTournaments(
            @RequestParam(required = false) String tournamentName,
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

            List<Tournament> tournaments = new ArrayList<Tournament>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Tournament> pageTuts;

            if (tournamentName == null)
                pageTuts = tournamentRepository.findAllStatusActive(pagingSort);
            else
                pageTuts = tournamentRepository.findByTournamentNameContaining(tournamentName, pagingSort);

            tournaments = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tournaments", tournaments);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Tournament findTournamentByID(@PathVariable int id){
        return service.getTournamentByID(id);
    }

//    @GetMapping("getTournamentByName/{tournamentName}")
//    public List <Tournament> findTournamentName(@PathVariable String tournamentName){
//        return service.getTournamentName(tournamentName);
//    }

    @PutMapping()
    public Tournament updateTournament(@RequestBody Tournament tournament){
        return service.updateTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public String deleteTournament(@PathVariable int id){
        return service.deleteTournament(id);
    }



}
