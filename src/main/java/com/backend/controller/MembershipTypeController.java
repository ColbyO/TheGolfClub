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

import com.backend.models.MembershipType; 
import com.backend.repositories.MembershipTypeRepository; 


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MembershipTypeController {
    @Autowired(required = false)
    MembershipTypeRepository Repo;

    @GetMapping("/membershiptype")
	public ResponseEntity<List<MembershipType>> getAllMembers(@RequestParam(required = false) String type) {
		try {
			List<MembershipType> membershipType = new ArrayList<MembershipType>();
			if (type == null)
                Repo.findAll().forEach(membershipType::add);
			else
                Repo.findByType(type).forEach(membershipType::add);

			if (type.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(membershipType, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/membershiptype/{id}")
	public ResponseEntity<MembershipType> getMembershipsById(@PathVariable("id") long id) {
		Optional<MembershipType> membershipTypeData = Repo.findById(id);

		if (membershipTypeData.isPresent()) {
			return new ResponseEntity<>(membershipTypeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/membershiptype")
    public ResponseEntity<MembershipType> createMembership(@RequestBody MembershipType membershipType) {
        try {
            MembershipType _membershipTypeRepo = Repo
                    .save(new MembershipType(membershipType.getId(), membershipType.getType(), membershipType.getPlan()));
            return new ResponseEntity<>(_membershipTypeRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/membershiptype/{id}")
    public ResponseEntity<MembershipType> updatedMembership(@PathVariable("id") long id, @RequestBody MembershipType membershipType) {
        Optional<MembershipType> membershipTypeInfo = Repo.findById(id);
        if (membershipTypeInfo.isPresent()) {
            MembershipType _membershipType = membershipTypeInfo.get();
            _membershipType.setId(membershipType.getId());
            _membershipType.setType(membershipType.getType());
            _membershipType.setPlan(membershipType.getPlan());
            return new ResponseEntity<>(Repo.save(_membershipType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/membershiptype/{id}")
    public ResponseEntity<MembershipType> deletedMembership(@PathVariable("id") long id){
        try{
            Repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
