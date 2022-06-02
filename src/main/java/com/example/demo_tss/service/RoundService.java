package com.example.demo_tss.service;
import com.example.demo_tss.entity.Round;
import com.example.demo_tss.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoundService {
    @Autowired
    private RoundRepository repository;

    public Round saveRound(Round round){
        return repository.save(round);
    }

    public List<Round>  saveRound(List<Round> round){
        return repository.saveAll(round);
    }
    public List<Round> getRound(){
        return repository.findAll();
    }
    public Round getRoundByID(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Round> getRoundByTournamentId(int tournamentId){

        return repository.findByTournamentId(tournamentId);
    }
    public String deletetRound(int id){
        repository.deleteById(id);
        return "Round removed " + id;
    }
    public Round updateRound(Round round){
        Round existingRound= repository.findById(round.getId()).orElse(null);
        existingRound.setTournamentId(round.getTournamentId());
        existingRound.setRoundName(round.getRoundName());
        existingRound.setStartDate(round.getStartDate());
        existingRound.setEndDate(round.getEndDate());
        return repository.save(existingRound);
    }

}
