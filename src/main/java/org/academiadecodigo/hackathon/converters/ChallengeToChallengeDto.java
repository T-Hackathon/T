package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.ChallengeDto;
import org.academiadecodigo.hackathon.persistence.model.Challenge;
import org.springframework.stereotype.Component;

@Component
public class ChallengeToChallengeDto {

    public ChallengeDto convert(Challenge challenge) {

        ChallengeDto challengeDto = new ChallengeDto();
        challengeDto.setId(challenge.getId());
        challengeDto.setName(challenge.getName());
        challengeDto.setStatus(challenge.getStatus());
        challengeDto.setVideos(challenge.getVideos());
        challengeDto.setLocation(challenge.getLocation());

        return challengeDto;
    }
}
