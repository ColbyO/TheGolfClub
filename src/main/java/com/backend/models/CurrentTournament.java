package com.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CurrentTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @JsonFormat(pattern = "dd/mm/yyyy")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate currentTournamentDate;

    @ManyToOne(targetEntity = Tournaments.class)
    private List<Tournaments> tournaments;

    public CurrentTournament() {}

    public CurrentTournament(long id, LocalDate currentTournamentDate, List<Tournaments> tournaments) {
        this.id = id;
        this.currentTournamentDate = currentTournamentDate;
        this.tournaments = tournaments;
    }

    public long getCurrentTournamentId() {
        return id;
    }

    public void setCurrentTournamentId(long id) {
        this.id = id;
    }

    public LocalDate getCurrentTournamentDate() {
        return currentTournamentDate;
    }

    public void setCurrentTournamentDate(LocalDate currentTournamentDate) {
        this.currentTournamentDate = currentTournamentDate;
    }

    public List<Tournaments> getTournament() {
        return tournaments;
    }

    public void setTournament(List<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }

}
