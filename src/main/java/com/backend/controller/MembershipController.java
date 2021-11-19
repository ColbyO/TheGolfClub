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

import com.backend.models.Membership; 
import com.backend.repositories.MembershipRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MembershipController {
    @Autowired(required = false)
    MembershipRepository membershipRepo;

    @GetMapping("/members")
	public ResponseEntity<List<Membership>> getAllMembers(@RequestParam(required = false) String firstName) {
		try {
			List<Membership> members = new ArrayList<Membership>();
			if (firstName == null)
                membershipRepo.findAll().forEach(members::add);
			else
                membershipRepo.findByFirstName(firstName).forEach(members::add);

			if (members.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(members, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/membership/{id}")
	public ResponseEntity<Membership> getMembershipsById(@PathVariable("id") long id) {
		Optional<Membership> membershipData = membershipRepo.findById(id);

		if (membershipData.isPresent()) {
			return new ResponseEntity<>(membershipData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/membership")
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership) {
        try {
            Membership _membershipRepo = membershipRepo
                    .save(new Membership(membership.getFirstName(),membership.getLastName(), membership.getAddress(), membership.getEmail(), membership.getPhoneNumber(),
                            membership.getStartDate(), membership.getDuration(), membership.getMembershipType(), membership.getPastTournaments(),
                            membership.getCurrentTournaments(), membership.getUpcomingTournaments()));
            return new ResponseEntity<>(_membershipRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/membership/{id}")
    public ResponseEntity<Membership> updatedMembership(@PathVariable("id") long id, @RequestBody Membership membership) {
        Optional<Membership> membershipInfo = membershipRepo.findById(id);
        if (membershipInfo.isPresent()) {
            Membership _membership = membershipInfo.get();
            _membership.setFirstName(membership.getFirstName());
            _membership.setLastName(membership.getLastName());
            _membership.setAddress(membership.getAddress());
            _membership.setEmail(membership.getEmail());
            _membership.setPhoneNumber(membership.getPhoneNumber());
            _membership.setStartDate(membership.getStartDate());
            _membership.setDuration(membership.getDuration());
            _membership.setMembershipType(membership.getMembershipType());
            _membership.setCurrentTournaments(membership.getCurrentTournaments());
            _membership.setPastTournaments(membership.getPastTournaments());
            _membership.setUpcomingTournaments(membership.getUpcomingTournaments());
            return new ResponseEntity<>(membershipRepo.save(_membership), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Membership/{id}")
    public ResponseEntity<Membership> deletedMembership(@PathVariable("id") long id){
        try{
            membershipRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
