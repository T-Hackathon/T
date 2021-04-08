package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.UserDto;
import org.academiadecodigo.hackathon.dto.VideoDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.springframework.stereotype.Component;

@Component
public class VideoToVideoDto {

    public VideoDto convert(Video video) {

        VideoDto videoDto = new VideoDto();
        videoDto.setId(video.getId());
        videoDto.setSrc(video.getSrc());
        videoDto.setLocation(video.getLocation());
        videoDto.setChallenge(video.getChallenge());

        return videoDto;
    }
}
