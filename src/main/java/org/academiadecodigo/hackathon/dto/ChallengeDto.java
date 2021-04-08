package org.academiadecodigo.hackathon.dto;

import org.academiadecodigo.hackathon.persistence.model.Location;
import org.academiadecodigo.hackathon.persistence.model.Video;

import javax.validation.constraints.*;
import java.util.List;

public class ChallengeDto {
    private Integer id;

    private String name;

    private Location location;

    private List<Video> videos;

    private boolean status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChallengeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", videos=" + videos +
                ", status=" + status +
                '}';
    }
}
