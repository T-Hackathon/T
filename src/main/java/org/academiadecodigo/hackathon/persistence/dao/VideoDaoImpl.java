package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.VideoDao;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.springframework.stereotype.Repository;

@Repository
public class VideoDaoImpl extends GenericDao<Video> implements VideoDao {

    public VideoDaoImpl() {
        super(Video.class);
    }
}
