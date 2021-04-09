package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video extends AbstractModel{
    //Fields
    private String src;

    @ManyToOne
    private Dancer dancer;

    @OneToOne
    private Location location;

    @ManyToOne
    private Challenge challenge;

    //Getters and Setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Dancer getUser() {
        return dancer;
    }

    public void setUser(Dancer dancer) {
        this.dancer = dancer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
