package com.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import com.backend.models.UpcomingTournament;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "UpcomingTournament", path = "UpcomingTournament")
public interface UpcomingTournamentRepository extends PagingAndSortingRepository<UpcomingTournament, Long> {
    List<UpcomingTournament> findByUpcomingTournamentDate(@Param("upcomingTournamentDate") LocalDate upcomingTournamentDate);
}
