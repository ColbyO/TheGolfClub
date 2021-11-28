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

import com.backend.models.UpcomingTournament; 
import com.backend.repositories.UpcomingTournamentRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UpcomingTournamentController {
    @Autowired(required = false)
    UpcomingTournamentRepository Repo;

    @GetMapping("/upcomingtournament")
	public ResponseEntity<List<UpcomingTournament>> getAllMembers(@RequestParam(required = false) LocalDate date) {
		try {
			List<UpcomingTournament> upcomingTournament = new ArrayList<UpcomingTournament>();
			if (date == null)
                Repo.findAll().forEach(upcomingTournament::add);
			else
                Repo.findByUpcomingTournamentDate(date).forEach(upcomingTournament::add);

			return new ResponseEntity<>(upcomingTournament, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/upcomingtournament/{id}")
	public ResponseEntity<UpcomingTournament> getMembershipsById(@PathVariable("id") long id) {
		Optional<UpcomingTournament> upcomingTournamentData = Repo.findById(id);

		if (upcomingTournamentData.isPresent()) {
			return new ResponseEntity<>(upcomingTournamentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/upcomingtournament")
    public ResponseEntity<UpcomingTournament> createMembership(@RequestBody UpcomingTournament upcomingTournament) {
        try {
            UpcomingTournament _upcomingTournamentRepo = Repo
                    .save(new UpcomingTournament(upcomingTournament.getUpcomingTournamentId(), upcomingTournament.getUpcomingTournamentDate(), upcomingTournament.getTournament(), upcomingTournament.getMembers()));
            return new ResponseEntity<>(_upcomingTournamentRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/upcomingtournament/{id}")
    public ResponseEntity<UpcomingTournament> updatedMembership(@PathVariable("id") long id, @RequestBody UpcomingTournament upcomingTournament) {
        Optional<UpcomingTournament> upcomingTournamentInfo = Repo.findById(id);
        if (upcomingTournamentInfo.isPresent()) {
            UpcomingTournament _upcomingTournament = upcomingTournamentInfo.get();
            _upcomingTournament.setUpcomingTournamentDate(upcomingTournament.getUpcomingTournamentDate());
            return new ResponseEntity<>(Repo.save(_upcomingTournament), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/upcomingtournament/{id}")
    public ResponseEntity<UpcomingTournament> deletedMembership(@PathVariable("id") long id){
        try{
            Repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
