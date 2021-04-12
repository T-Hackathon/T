package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.ChallengeDto;
import org.academiadecodigo.hackathon.persistence.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.academiadecodigo.hackathon.service.ChallengeService;
import org.springframework.stereotype.Component;

@Component
public class ChallengeDtoToChallenge {


    private ChallengeService challengeService;

    @Autowired
    public void setChallengeService(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    public Challenge convert(ChallengeDto challengeDto) {

        Challenge challenge = (challengeDto.getId() != null ? challengeService.get(challengeDto.getId()) : new Challenge());

        challenge.setNameChallenge(challengeDto.getName());
        challenge.setLocation(challengeDto.getLocation());
        challenge.setVideos(challengeDto.getVideos());
        challenge.setStatus(challengeDto.isStatus());

        return challenge;
    }
}
