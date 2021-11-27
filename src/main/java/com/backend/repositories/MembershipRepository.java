package com.backend.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.backend.models.Membership;

@Repository
@RepositoryRestResource(collectionResourceRel = "Membership", path = "Membership")
public interface MembershipRepository extends PagingAndSortingRepository<Membership, Long> {
    List<Membership> findByStartDate(@Param("startdate") LocalDate startDate);
    List<Membership> findByDuration(@Param("duration") LocalTime duration);
}

