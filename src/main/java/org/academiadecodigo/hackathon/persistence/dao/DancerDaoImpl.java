package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.DancerDao;
import org.academiadecodigo.hackathon.persistence.model.Dancer;
import org.springframework.stereotype.Repository;

@Repository
public class DancerDaoImpl extends GenericDao<Dancer> implements DancerDao {

    public DancerDaoImpl() {
        super(Dancer.class);
    }
}
