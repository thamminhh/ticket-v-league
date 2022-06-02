package com.example.demo_tss.service;
import com.example.demo_tss.entity.Area;
import com.example.demo_tss.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional


public class AreaService {

    @Autowired
    private AreaRepository repository;

    public Area saveArea(Area area){
        return repository.save(area);
    }

    public List<Area>  saveArea(List<Area> area){
        return repository.saveAll(area);
    }
    public List<Area> getArea(){
        return repository.findAll();
    }
    public Area getAreaByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Area> getAreaByStadiumId(int stadiumId){

        return repository.findByStadiumId(stadiumId);
    }
    public String deleteArea(int id){
        repository.deleteById(id);
        return "Area removed " + id;
    }
    public Area updateArea(Area area){
        Area existingArea= repository.findById(area.getId()).orElse(null);
        existingArea.setAreaName(area.getAreaName());
        existingArea.setStadiumId(area.getStadiumId());
        existingArea.setCapacity(area.getCapacity());
        return repository.save(existingArea);
    }
}
