package com.backend.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "membership")
public class Membership {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonFormat(pattern = "hh-mm-ss")
    @DateTimeFormat(pattern = "hh-mm-ss")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "duration")
    private LocalTime duration;

    @OneToOne
    private MembershipType membershipType;
    
    public Membership(long id, LocalDate startDate, LocalTime duration, MembershipType membershipType) {
        this.id = id;
        this.startDate = startDate;
        this.duration = duration;
        this.membershipType = membershipType;
    }

    public Membership() {
        
    }

    public long getId() {
        return this.id;
    }

    public void setid(long id) {
        this.id = id;
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

    public MembershipType getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

}
