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

import com.backend.models.CurrentTournament; 
import com.backend.repositories.CurrentTournamentRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CurrentTournamentController {
    @Autowired(required = false)
    CurrentTournamentRepository Repo;

    @GetMapping("/currenttournament")
	public ResponseEntity<List<CurrentTournament>> getAllMembers(@RequestParam(required = false) LocalDate date) {
		try {
			List<CurrentTournament> currentTournament = new ArrayList<CurrentTournament>();
			if (date == null)
                Repo.findAll().forEach(currentTournament::add);
			else
                Repo.findByCurrentTournamentDate(date).forEach(currentTournament::add);

			return new ResponseEntity<>(currentTournament, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/currenttournament/{id}")
	public ResponseEntity<CurrentTournament> getMembershipsById(@PathVariable("id") long id) {
		Optional<CurrentTournament> currentTournamentData = Repo.findById(id);

		if (currentTournamentData.isPresent()) {
			return new ResponseEntity<>(currentTournamentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/currenttournament")
    public ResponseEntity<CurrentTournament> createMembership(@RequestBody CurrentTournament currentTournament) {
        try {
            CurrentTournament _membershipTypeRepo = Repo
                    .save(new CurrentTournament(currentTournament.getCurrentTournamentId(), currentTournament.getCurrentTournamentDate(), currentTournament.getTournament(), currentTournament.getMembers()));
            return new ResponseEntity<>(_membershipTypeRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/currenttournament/{id}")
    public ResponseEntity<CurrentTournament> updatedMembership(@PathVariable("id") long id, @RequestBody CurrentTournament currentTournament) {
        Optional<CurrentTournament> currentTournamentInfo = Repo.findById(id);
        if (currentTournamentInfo.isPresent()) {
            CurrentTournament _currentTournament = currentTournamentInfo.get();
            _currentTournament.setCurrentTournamentId(currentTournament.getCurrentTournamentId());
            _currentTournament.setCurrentTournamentDate(currentTournament.getCurrentTournamentDate());
            return new ResponseEntity<>(Repo.save(_currentTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/currenttournament/{id}")
    public ResponseEntity<CurrentTournament> deletedMembership(@PathVariable("id") long id){
        try{
            Repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
