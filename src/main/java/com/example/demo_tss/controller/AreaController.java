package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Area;
import com.example.demo_tss.repository.AreaRepository;
import com.example.demo_tss.service.AreaService;
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
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService service;

    @Autowired
    private AreaRepository areaRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @PostMapping()
    public Area addArea(@RequestBody Area area){
        return service.saveArea(area);
    }
    @GetMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Map<String, Object>> getAreas( Pageable pageable
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "4") int size,
//            @RequestParam(defaultValue = "id,asc") String[] sort
           ) {
        try {
//            List<Sort.Order> orders = new ArrayList<Sort.Order>();
//            if (sort[0].contains(",")) {
//                // will sort more than 2 fields
//                // sortOrder="field, direction"
//                for (String sortOrder : sort) {
//                    String[] _sort = sortOrder.split(",");
//                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
//                }
//            } else {
//                // sort=[field, direction]
//                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
//            }
//
            List<Area> areas = new ArrayList<Area>();
//            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Area> pageTuts;

            pageTuts = areaRepository.findAllInfo(pageable);

            areas = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("areas", areas);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Area findAreaByID(@PathVariable int id){
        return service.getAreaByID(id);
    }

    @GetMapping("/stadiumId/{stadiumId}")
    public List <Area> findAreaByStadiumId(@PathVariable int stadiumId){
        return service.getAreaByStadiumId(stadiumId);
    }

    @PutMapping()
    public Area updateArea(@RequestBody Area area){
        return service.saveArea(area);
    }

    @DeleteMapping("/{id}")
    public String deleteArea(@PathVariable int id){

        return service.deleteArea(id);
    }
}
