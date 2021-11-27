package com.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import com.backend.models.PastTournament;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "PastTournament", path = "PastTournament")
public interface PastTournamentRepository extends PagingAndSortingRepository<PastTournament, Long> {
    List<PastTournament> findByPastTournamentDate(@Param("pastTournamentDate") LocalDate pastTournamentDate);
}
