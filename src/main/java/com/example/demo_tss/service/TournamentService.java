package com.example.demo_tss.service;


import com.example.demo_tss.entity.Tournament;
import com.example.demo_tss.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TournamentService {

    @Autowired
    private TournamentRepository repository;

    public Tournament saveTournament(Tournament tournament) {
        return repository.save(tournament);
    }

    public List<Tournament> getTournaments() {
        return repository.findAll();
    }

    public Tournament getTournamentByID(int id) {
        return repository.findById(id).orElse(null);
    }

//    public List<Tournament> getTournamentName(String tournamentName) {
//
//        return repository.findByTournamentName(tournamentName);
//    }

    public String deleteTournament(int id) {
        repository.deleteById(id);
        return "Tournament removed " + id;
    }

    public Tournament updateTournament(Tournament tournament) {
        Tournament existingTournament = repository.findById(tournament.getId()).orElse(null);
        existingTournament.setTournamentName(tournament.getTournamentName());
        existingTournament.setStartDate(tournament.getStartDate());
        existingTournament.setEndDate(tournament.getEndDate());
        return repository.save(existingTournament);
    }
}
