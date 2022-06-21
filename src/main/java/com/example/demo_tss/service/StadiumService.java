package com.example.demo_tss.service;

import com.example.demo_tss.entity.Accounts;
import com.example.demo_tss.entity.Stadium;
import com.example.demo_tss.repository.AccountsRepository;
import com.example.demo_tss.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class StadiumService {
    @Autowired
    private StadiumRepository repository;

    public Stadium saveStadium(Stadium stadium){
        return repository.save(stadium);
    }

    public List<Stadium>  saveStadium(List<Stadium> stadiums){
        return repository.saveAll(stadiums);
    }
    public List<Stadium> getStadium(){
        return repository.findAll();
    }
    public Stadium getStadiumByID(int id){
        return repository.findById(id).orElse(null);
    }
//    public List<Stadium> getStadiumByStadiumName(String stadiumName){
//
//        return repository.findByStadiumName(stadiumName);
//    }
    public String deleteStadium(int id){
        repository.deleteById(id);
        return "Stadium removed " + id;
    }
    public Stadium updateStadium(Stadium stadium){
        Stadium existingStadium= repository.findById(stadium.getId()).orElse(null);
        existingStadium.setStadiumName(stadium.getStadiumName());
        existingStadium.setLocation(stadium.getLocation());
        existingStadium.setCapacity(stadium.getCapacity());
        existingStadium.setImg(stadium.getImg());
        return repository.save(existingStadium);
    }
}
