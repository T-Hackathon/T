package org.academiadecodigo.hackathon.service;


import org.academiadecodigo.hackathon.persistence.model.Challenge;

import java.util.List;

public interface ChallengeService {

    Challenge get(Integer id);

    List<Challenge> list();

    Challenge save(Challenge user);
}
