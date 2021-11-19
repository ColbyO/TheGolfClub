package com.backend.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.backend.models.Membership;

@RepositoryRestResource(collectionResourceRel = "Membership", path = "Membership")
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByFirstName(String firstName);
    List<Membership> findByLastName(String lastName);
    List<Membership> findByAddress(String address);
    List<Membership> findByEmail(String email);
    List<Membership> findByPhoneNumber(int phoneNumber);
    List<Membership> findByStartDate(LocalDate startDate);
    List<Membership> findByDuration(LocalTime duration);
    List<Membership> findBymembershipType(String membershipType);
    List<Membership> findByCurrentTournaments(String currentTournaments);
    List<Membership> findByPastTournaments(String pastTournaments);
    List<Membership> findByUpcomingTournaments(String upcomingTournaments);
}
