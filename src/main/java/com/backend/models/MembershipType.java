package com.backend.models;

import javax.persistence.*;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String plan;

    @OneToOne
    private Membership member;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Membership getMember() {
        return member;
    }

    public void setMember(Membership member) {
        this.member = member;
    }
}
