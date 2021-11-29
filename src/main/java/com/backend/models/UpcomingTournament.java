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
public class UpcomingTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate upcomingTournamentDate;

    @ManyToOne(targetEntity = Tournaments.class)
    private List<Tournaments> tournaments;

    public UpcomingTournament() {}

    public UpcomingTournament(long id, LocalDate upcomingTournamentDate, List<Tournaments> tournaments) {
        this.id = id;
        this.upcomingTournamentDate = upcomingTournamentDate;
        this.tournaments = tournaments;
    }

    public long getUpcomingTournamentId() {
        return id;
    }

    public void setUpcomingTournamentId(long id) {
        this.id = id;
    }

    public LocalDate getUpcomingTournamentDate() {
        return upcomingTournamentDate;
    }

    public void setUpcomingTournamentDate(LocalDate upcomingTournamentDate) {
        this.upcomingTournamentDate = upcomingTournamentDate;
    }

    public List<Tournaments> getTournament() {
        return tournaments;
    }

    public void setTournament(List<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }

}
