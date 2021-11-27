package com.backend.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "members")
// @MappedSuperclass
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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

    @OneToMany
    private List<Membership> membership;

    @ManyToOne(targetEntity = CurrentTournament.class)
    private List<CurrentTournament> currentTournaments;

    @ManyToOne(targetEntity = PastTournament.class)
    private List<PastTournament> pastTournaments;

    @ManyToOne(targetEntity = UpcomingTournament.class)
    private List<UpcomingTournament> upcomingTournaments; 

    public Members(long id, String firstName, String lastName, String address, String email, int phoneNumber, List<Membership> membership,
    List<CurrentTournament> currentTournament, List<PastTournament> pastTournament, List<UpcomingTournament> upcomingTournament) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membership = membership;
        this.currentTournaments = currentTournament;
        this.pastTournaments = pastTournament;
        this.upcomingTournaments = upcomingTournament;
    }

    public Members() {

    }

    public long getId() {
        return id;
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
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Membership> getMembership() {
        return this.membership;
    }

    public void setMembership(List<Membership> membership) {
        this.membership = membership;
    }

    public List<CurrentTournament> getCurrentTournaments() {
        return this.currentTournaments;
    }

    public void setCurrentTournaments(List<CurrentTournament> currentTournaments) {
        this.currentTournaments = currentTournaments;
    }

    public List<PastTournament> getPastTournaments() {
        return this.pastTournaments;
    }

    public void setPastTournaments(List<PastTournament> pastTournaments) {
        this.pastTournaments = pastTournaments;
    }

    public List<UpcomingTournament> getUpcomingTournaments() {
        return this.upcomingTournaments;
    }

    public void setUpcomingTournaments(List<UpcomingTournament> upcomingTournaments) {
        this.upcomingTournaments = upcomingTournaments;
    } 
}
