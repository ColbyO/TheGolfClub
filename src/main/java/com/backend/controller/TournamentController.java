package com.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Tournaments;
import com.backend.repositories.TournamentRepository;

@CrossOrigin(origins = "http://localhost:5432")
@RestController
@RequestMapping("/api")
public class TournamentController {
    @Autowired(required = false)
    TournamentRepository tournamentRepo;
    
    @GetMapping("/tournaments")
    public ResponseEntity<List<Tournaments>> getAllTournamentsByTime(@RequestParam(required = false) String startDate, String endDate) {
        try{
            List<Tournaments> Tournament = new ArrayList<Tournaments>();
            if(startDate == null & endDate == null)
                tournamentRepo.findAll().forEach(Tournament::add);
            else if (startDate == null)
                tournamentRepo.findByStartDate(startDate).forEach(Tournament::add);
            else
                tournamentRepo.findByEndDate(endDate).forEach(Tournament::add);
            return new ResponseEntity<>(Tournament, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping ("/tournament")
    public ResponseEntity<Tournaments> postTournament(@RequestBody Tournaments tournament) {
        try{
            Tournaments _tournament = tournamentRepo
                            .save(new Tournaments(tournament.getStart(), tournament.getEnd(), tournament.getFee(),
                            tournament.getPrize(), tournament.getMembers(), tournament.getStandings()));
            return new ResponseEntity<>(_tournament, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tournament/{id}")
    public ResponseEntity<Tournaments> updatedMembership(@PathVariable("id") long id, @RequestBody Tournaments tournament) {
        Optional<Tournaments> tournamentInfo = tournamentRepo.findById(id);
        if (tournamentInfo.isPresent()) {
            Tournaments tournament1 = tournamentInfo.get();
            tournament1.setStart(tournament1.getStart());
            tournament1.setEnd(tournament1.getEnd());
            tournament1.setFee(tournament1.getFee());
            tournament1.setPrize(tournament1.getPrize());
            tournament1.setMembers(tournament1.getMembers());
            tournament1.setStandings(tournament1.getStandings());
            return new ResponseEntity<>(tournamentRepo.save(tournament1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/tournament/{id}")
    public ResponseEntity<Tournaments> deletedTournament(@PathVariable("id") long id){
        try{
            tournamentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
