package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.VideoDao;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VideoServiceImpl implements VideoService {
    private VideoDao videoDao;

    @Autowired
    public void setVideoDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public Video get(Integer id) {
        return videoDao.findById(id);
    }

    @Override
    public List<Video> list() {
        return videoDao.findAll();
    }

    @Transactional
    @Override
    public Video save(Video video) {
        return videoDao.saveOrUpdate(video);
    }

}
