package com.backend.Tournament;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "entry_fee")
    private int fee;

    @Column(name = "prize")
    private int prize;

    @Column(name = "participating")
    private String members;
    
    @Column(name = "standings")
    private String standings;

    public LocalDate getStart() {
        return this.startDate;
    }

    public void setStart(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEnd() {
        return this.endDate;
    }

    public void setEnd(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPrize() {
        return this.prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getMembers() {
        return this.members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getStandings() {
        return this.standings;
    }

    public void setStandings(String standings) {
        this.standings = standings;
    }
}