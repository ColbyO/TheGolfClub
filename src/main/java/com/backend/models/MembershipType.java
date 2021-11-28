package com.backend.models;

import javax.persistence.*;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String plan;

    public MembershipType() {}

    public MembershipType(long id, String type, String plan) {
        this.id = id;
        this.type = type;
        this.plan = plan;
    }

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

}
