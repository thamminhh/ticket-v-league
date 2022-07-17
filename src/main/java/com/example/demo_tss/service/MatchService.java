package com.example.demo_tss.service;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class MatchService {
    @Autowired
    private MatchRepository repository;

    public Match saveMatch(Match match){
        return repository.save(match);
    }

    public List<Match>  saveMatch(List<Match> match){
        return repository.saveAll(match);
    }
//    public List<Match> getMatch(){
//        return repository.findAll();
//    }
    public Match getMatchByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Match> getMatchByStadiumId(int stadiumId){

        return repository.findByStadiumId(stadiumId);
    }
    public List<Match> getMatchByRoundId(int roundId){

        return repository.findByRoundId(roundId);
    }
    public List<Match> getMatchByClubHomeId(int clubHomeId){

        return repository.findByClubHomeId(clubHomeId);
    }
    public List<Match> getMatchByClubVisitorId(int clubVisitorId){

        return repository.findByClubVisitorId(clubVisitorId);
    }
    public String deleteMatch(int id){
        repository.deleteById(id);
        return "Match removed " + id;
    }
    public Match updateMatch(Match match){
        Match existingMatch= repository.findById(match.getId()).orElse(null);
        existingMatch.setRoundId(match.getRoundId());
        existingMatch.setStadiumId(match.getStadiumId());
        existingMatch.setClubHomeId(match.getClubHomeId());
        existingMatch.setClubVisitorId(match.getClubVisitorId());
        existingMatch.setTimeStart(match.getTimeStart());
        return repository.save(existingMatch);
    }
}
