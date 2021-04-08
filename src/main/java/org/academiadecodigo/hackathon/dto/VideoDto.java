package org.academiadecodigo.hackathon.dto;

import org.academiadecodigo.hackathon.persistence.model.Challenge;
import org.academiadecodigo.hackathon.persistence.model.Location;

public class VideoDto {

    private Integer id;

    private String src;

    private Location location;

    private Challenge challenge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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
