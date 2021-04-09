package org.academiadecodigo.hackathon.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "challenge")
public class Challenge extends AbstractModel{
    //Fields
    private String nameChallenge;

    @OneToOne
    private Location location;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove recipients if unlinked from customer
            orphanRemoval = true,

            // use recipient foreign key on recipient table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "challenge",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Video> videos;

    private Boolean Status;

    //Getters and Setters
    public String getNameChallenge() {
        return nameChallenge;
    }

    public void setNameChallenge(String nameChallenge) {
        this.nameChallenge = nameChallenge;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
