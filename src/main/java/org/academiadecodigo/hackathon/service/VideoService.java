package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.model.Challenge;
import org.academiadecodigo.hackathon.persistence.model.Video;

import java.util.List;

public interface VideoService {

    Video get(Integer id);

    List<Video> list();

    Video save(Video video);

}

