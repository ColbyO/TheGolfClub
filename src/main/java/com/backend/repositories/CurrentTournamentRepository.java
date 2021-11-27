package com.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import com.backend.models.CurrentTournament;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "CurrentTournament", path = "CurrentTournament")
public interface CurrentTournamentRepository extends PagingAndSortingRepository<CurrentTournament, Long> {
    List<CurrentTournament> findByCurrentTournamentDate(@Param("currentTournamentDate") LocalDate currentTournamentDate);
}
