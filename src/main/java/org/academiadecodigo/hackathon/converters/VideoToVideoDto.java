package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.VideoDto;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.springframework.stereotype.Component;

@Component
public class VideoToVideoDto {

    public VideoDto convert(Video video) {

        VideoDto videoDto = new VideoDto();
        videoDto.setId(video.getId());
        videoDto.setSrc(video.getSrc());

        return videoDto;
    }
}
