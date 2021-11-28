package com.backend.controller;

import java.time.LocalDate;
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

import com.backend.models.PastTournament; 
import com.backend.repositories.PastTournamentRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PastTournamentController {
    @Autowired(required = false)
    PastTournamentRepository Repo;

    @GetMapping("/pasttournament")
	public ResponseEntity<List<PastTournament>> getAllMembers(@RequestParam(required = false) LocalDate date) {
		try {
			List<PastTournament> pastTournament = new ArrayList<PastTournament>();
			if (date == null)
                Repo.findAll().forEach(pastTournament::add);
			else
                Repo.findByPastTournamentDate(date).forEach(pastTournament::add);

			return new ResponseEntity<>(pastTournament, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/pasttournament/{id}")
	public ResponseEntity<PastTournament> getMembershipsById(@PathVariable("id") long id) {
		Optional<PastTournament> pastTournamentData = Repo.findById(id);

		if (pastTournamentData.isPresent()) {
			return new ResponseEntity<>(pastTournamentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/pasttournament")
    public ResponseEntity<PastTournament> createMembership(@RequestBody PastTournament pastTournament) {
        try {
            PastTournament _pastTournamentRepo = Repo
                    .save(new PastTournament(pastTournament.getPastTournamentId(), pastTournament.getPastTournamentDate(), pastTournament.getTournament(), pastTournament.getMembers()));
            return new ResponseEntity<>(_pastTournamentRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pasttournament/{id}")
    public ResponseEntity<PastTournament> updatedMembership(@PathVariable("id") long id, @RequestBody PastTournament pastTournament) {
        Optional<PastTournament> pastTournamentInfo = Repo.findById(id);
        if (pastTournamentInfo.isPresent()) {
            PastTournament _pastTournament = pastTournamentInfo.get();
            _pastTournament.setPastTournamentId(pastTournament.getPastTournamentId());
            _pastTournament.setPastTournamentDate(pastTournament.getPastTournamentDate());
            return new ResponseEntity<>(Repo.save(_pastTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pasttournament/{id}")
    public ResponseEntity<PastTournament> deletedMembership(@PathVariable("id") long id){
        try{
            Repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
