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
public class PastTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate pastTournamentDate;

    @ManyToOne(targetEntity = Tournaments.class)
    private List<Tournaments> tournaments;

    public PastTournament() {}

    public PastTournament(long id, LocalDate pastTournamentDate, List<Tournaments> tournaments) {
        this.id = id;
        this.pastTournamentDate = pastTournamentDate;
        this.tournaments = tournaments;
    }

    public long getPastTournamentId() {
        return id;
    }

    public void setPastTournamentId(long id) {
        this.id = id;
    }

    public LocalDate getPastTournamentDate() {
        return pastTournamentDate;
    }

    public void setPastTournamentDate(LocalDate pastTournamentDate) {
        this.pastTournamentDate = pastTournamentDate;
    }

    public List<Tournaments> getTournament() {
        return tournaments;
    }

    public void setTournament(List<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }

}
