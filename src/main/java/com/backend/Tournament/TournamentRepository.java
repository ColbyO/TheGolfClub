package com.backend.Tournament;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Tournament.*;

public interface TournamentRepository extends JpaRepository<Tournament, Long>{
    List<Tournament> findByStartDate(LocalDate Start);
}