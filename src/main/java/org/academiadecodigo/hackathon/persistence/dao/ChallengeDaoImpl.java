package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.ChallengeDao;
import org.springframework.stereotype.Repository;

@Repository
public class ChallengeDaoImpl extends GenericDao<Challenge> implements ChallengeDao {

    public ChallengeDaoImpl() {
        super(Challenge.class);
    }
}
