package com.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

import com.backend.models.Members; 
import com.backend.repositories.MembersRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@Component
public class MembersController {
    @Autowired(required = false)
    MembersRepository membersRepo;

    @GetMapping("/members")
	public ResponseEntity<List<Members>> getAllMembers(@RequestParam(required = false) String firstName) {
		try {
			List<Members> _members = new ArrayList<Members>();
			if (firstName == null)
                membersRepo.findAll().forEach(_members::add);
			else
                membersRepo.findByFirstName(firstName).forEach(_members::add);

			if (_members.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(_members, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/members/{id}")
	public ResponseEntity<Members> getMembersById(@PathVariable("id") long id) {
		Optional<Members> membersData = membersRepo.findById(id);

		if (membersData.isPresent()) {
			return new ResponseEntity<>(membersData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/members")
    public ResponseEntity<Members> createMember(@RequestBody Members members) {
        try {
            Members _membersRepo = membersRepo
                    .save(new Members(members.getId(), members.getFirstName(),members.getLastName(), members.getAddress(), members.getEmail(), members.getPhoneNumber(), 
                    members.getMembership(), members.getCurrentTournaments(), members.getPastTournaments(), members.getUpcomingTournaments()));
            return new ResponseEntity<>(_membersRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Members> updatedMembers(@PathVariable("id") long id, @RequestBody Members members) {
        Optional<Members> membersInfo = membersRepo.findById(id);
        if (membersInfo.isPresent()) {
            Members _members = membersInfo.get();
            _members.setId(members.getId());
            _members.setFirstName(members.getFirstName());
            _members.setLastName(members.getLastName());
            _members.setAddress(members.getAddress());
            _members.setEmail(members.getEmail());
            _members.setPhoneNumber(members.getPhoneNumber());
            _members.setMembership(members.getMembership());
            _members.setCurrentTournaments(members.getCurrentTournaments());
            _members.setPastTournaments(members.getPastTournaments());
            _members.setUpcomingTournaments(members.getUpcomingTournaments());
            return new ResponseEntity<>(membersRepo.save(_members), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Members> deletedMembers(@PathVariable("id") long id){
        try{
            membersRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}