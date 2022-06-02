package com.example.demo_tss.service;


import com.example.demo_tss.entity.Club;
import com.example.demo_tss.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class ClubService {

    @Autowired
    private ClubRepository repository;

    public Club saveClub(Club club){
        return repository.save(club);
    }

    public List<Club>  saveClub(List<Club> club){
        return repository.saveAll(club);
    }
    public List<Club> getClub(){
        return repository.findAll();
    }
    public Club getClubByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Club> getClubByStadiumId(int stadiumId){

        return repository.findByStadiumId(stadiumId);
    }
    public String deleteClub(int id){
        repository.deleteById(id);
        return "Club removed " + id;
    }
    public Club updateClub(Club club){
        Club existingClub= repository.findById(club.getId()).orElse(null);
        existingClub.setStadiumId(club.getStadiumId());
        existingClub.setClubName(club.getClubName());
        existingClub.setCountry(club.getCountry());
        existingClub.setImg(club.getImg());
        return repository.save(existingClub);
    }
}
