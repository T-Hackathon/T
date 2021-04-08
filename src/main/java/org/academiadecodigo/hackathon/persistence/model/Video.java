package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video extends AbstractModel{
    //Fields
    private String src;

    @ManyToOne
    private User User;

    @ManyToOne
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

    public org.academiadecodigo.hackathon.persistence.model.User getUser() {
        return User;
    }

    public void setUser(org.academiadecodigo.hackathon.persistence.model.User user) {
        User = user;
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
