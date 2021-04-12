package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.VideoDto;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.academiadecodigo.hackathon.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoDtoToVideo {

    private VideoService videoService;

    @Autowired
    public void setUserService(VideoService videoService) {
        this.videoService = videoService;
    }

    public Video convert(VideoDto videoDto) {

        Video video = (videoDto.getId() != null ? videoService.get(videoDto.getId()) : new Video());

        video.setSrc(videoDto.getSrc());

        return video;
    }
}
