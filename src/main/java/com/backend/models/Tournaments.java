package com.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "tournaments")
public class Tournaments {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "entry_fee")
    private double fee;

    @Column(name = "prize")
    private double prize;

    @Column(name = "participating")
    private String members;
    
    @Column(name = "standings")
    private String standings;

    public Tournaments(String startDate, String endDate, double fee, double prize, String members, String standings){
        this.startDate = startDate;
        this.endDate = endDate;
        this.fee = fee;
        this.prize = prize;
        this.members = members;
        this.standings = standings;
    }

    public Tournaments() {
        
    }

    public String getStart() {
        return this.startDate;
    }

    public void setStart(String startDate) {
        this.startDate = startDate;
    }

    public String getEnd() {
        return this.endDate;
    }

    public void setEnd(String endDate) {
        this.endDate = endDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getPrize() {
        return this.prize;
    }

    public void setPrize(double prize) {
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
