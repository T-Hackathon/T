package org.academiadecodigo.hackathon.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video extends AbstractModel{
    //Fields
    private String src;

    @ManyToOne
    private Dancer dancer;

    @JsonBackReference
    @ManyToOne
    private Challenge challenge;

    //Getters and Setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Dancer getDancer() {
        return dancer;
    }

    public void setDancer(Dancer dancer) {
        this.dancer = dancer;
    }


    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
