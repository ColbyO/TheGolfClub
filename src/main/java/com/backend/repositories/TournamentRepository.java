package com.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.backend.models.Tournaments;

@RepositoryRestResource(collectionResourceRel = "Tournament", path = "Tournament")
public interface TournamentRepository extends JpaRepository<Tournaments, Long> {
    List<Tournaments> findByStartDate(String startDate);
    List<Tournaments> findByEndDate(String endDate);
    List<Tournaments> findByFee(double fee);
    List<Tournaments> findByPrize(double prize);
    List<Tournaments> findByMembers(String members);
    List<Tournaments> findByStandings(String standings);
}
