package com.backend.Membership;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "members")
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phoneNumber;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "type")
    private String membershipType;

    @Column(name = "current_tournament")
    private String currentTournaments;
    
    @Column(name = "past_tournament")
    private String pastTournaments;

    @Column(name = "upcoming_tournament")
    private String upcomingTournaments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getDuration() {
        return this.duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getCurrentTournaments() {
        return this.currentTournaments;
    }

    public void setCurrentTournaments(String currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public String getPastTournaments() {
        return this.pastTournaments;
    }

    public void setPastTournaments(String pastTournaments) {
        this.pastTournaments = pastTournaments;
    }

    public String getUpcomingTournaments() {
        return this.upcomingTournaments;
    }

    public void setUpcomingTournaments(String upcomingTournaments) {
        this.upcomingTournaments = upcomingTournaments;
    }
}
