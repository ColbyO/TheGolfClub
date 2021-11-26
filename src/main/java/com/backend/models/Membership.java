package com.backend.models;

import javax.persistence.*;

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
    private String startDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "type")
    private String membershipType;

    @Column(name = "current_tournament")
    private String currentTournaments;
    
    @Column(name = "past_tournament")
    private String pastTournaments;

    @Column(name = "upcoming_tournament")
    private String upcomingTournaments;

    public Membership(long id, String firstName, String lastName, String address, String email, int phonenumber, String startDate,
    String duration, String membershipType, String pastTournaments,
                      String currentTournaments, String upcomingTournaments) {
        this.id = id;                          
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phonenumber;
        this.startDate = startDate;
        this.duration = duration;
        this.membershipType = membershipType;
        this.pastTournaments = pastTournaments;
        this.currentTournaments = currentTournaments;
        this.upcomingTournaments = upcomingTournaments;
    }

    public Membership() {
        
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
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
