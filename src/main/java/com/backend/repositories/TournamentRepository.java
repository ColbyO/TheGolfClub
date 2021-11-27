package com.backend.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.backend.models.Tournaments;

@RepositoryRestResource(collectionResourceRel = "Tournament", path = "Tournament")
public interface TournamentRepository extends PagingAndSortingRepository<Tournaments, Long> {
    List<Tournaments> findByStartDate(@Param("startDate") String startDate);
    List<Tournaments> findByEndDate(@Param("endDate") String endDate);
    List<Tournaments> findByFee(@Param("fee") double fee);
    List<Tournaments> findByPrize(@Param("prize") double prize);
    List<Tournaments> findByMembers(@Param("members") String members);
    List<Tournaments> findByStandings(@Param("standings") String standings);
}
