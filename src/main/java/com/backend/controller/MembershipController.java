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

import com.backend.models.Membership; 
import com.backend.repositories.MembershipRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MembershipController {
    @Autowired(required = false)
    MembershipRepository Repo;

    @GetMapping("/membership")
	public ResponseEntity<List<Membership>> getAllMembers(@RequestParam(required = false) LocalDate startDate) {
		try {
			List<Membership> members = new ArrayList<Membership>();
			if (startDate == null)
                Repo.findAll().forEach(members::add);
			else
                Repo.findByStartDate(startDate).forEach(members::add);

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
		Optional<Membership> membershipData = Repo.findById(id);

		if (membershipData.isPresent()) {
			return new ResponseEntity<>(membershipData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/membership")
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership) {
        try {
            Membership _membershipRepo = Repo
                    .save(new Membership(membership.getId(), membership.getStartDate(), membership.getDuration(), membership.getMembershipType(), membership.getMember()));
            return new ResponseEntity<>(_membershipRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/membership/{id}")
    public ResponseEntity<Membership> updatedMembership(@PathVariable("id") long id, @RequestBody Membership membership) {
        Optional<Membership> membershipInfo = Repo.findById(id);
        if (membershipInfo.isPresent()) {
            Membership _membership = membershipInfo.get();
            _membership.setStartDate(membership.getStartDate());
            _membership.setDuration(membership.getDuration());
            _membership.setMembershipType(membership.getMembershipType());
            _membership.setMember(membership.getMember());
            return new ResponseEntity<>(Repo.save(_membership), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/membership/{id}")
    public ResponseEntity<Membership> deletedMembership(@PathVariable("id") long id){
        try{
            Repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
