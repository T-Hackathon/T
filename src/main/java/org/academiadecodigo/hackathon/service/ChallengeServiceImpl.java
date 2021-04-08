package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.ChallengeDao;
import org.academiadecodigo.hackathon.persistence.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChallengeServiceImpl implements  ChallengeService{
    //Fields
    private ChallengeDao challengeDao;

    @Autowired
    public void setChallengeDao(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @Override
    public Challenge get(Integer id) {
        return challengeDao.findById(id);
    }

    @Override
    public List<Challenge> list() {
        return challengeDao.findAll();
    }

    @Transactional
    @Override
    public Challenge save(Challenge challenge) {
        return challengeDao.saveOrUpdate(challenge);
    }
}
