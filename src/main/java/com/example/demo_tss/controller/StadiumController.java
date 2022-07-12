package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Stadium;
import com.example.demo_tss.repository.StadiumRepository;
import com.example.demo_tss.service.StadiumService;
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
@RequestMapping("/stadium")
public class StadiumController {
    @Autowired
    private StadiumService service;

    @Autowired
    private StadiumRepository stadiumRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public Stadium addStadium(@RequestBody Stadium stadium){
        return service.saveStadium(stadium);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getStadiums(
            @RequestParam(required = false) String stadiumName,
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

            List<Stadium> stadiums = new ArrayList<Stadium>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Stadium> pageTuts;

            if (stadiumName == null)
                pageTuts = stadiumRepository.findAllInfo(pagingSort);
            else
                pageTuts = stadiumRepository.findByStadiumNameContaining(stadiumName, pagingSort);

            stadiums = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("stadiums", stadiums);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Stadium findStadiumByID(@PathVariable int id){
        return service.getStadiumByID(id);
    }

//    @GetMapping("stadiumName/{stadiumName}")
//    public List <Stadium> findStadiumByName(@PathVariable String stadiumName){
//        return service.getStadiumByStadiumName(stadiumName);
//    }

    @PutMapping("")
    public Stadium updateStadium(@RequestBody Stadium stadium){
        return service.saveStadium(stadium);
    }

    @DeleteMapping("/{id}")
    public String deteleStadium(@PathVariable int id){

        return service.deleteStadium(id);
    }
}
