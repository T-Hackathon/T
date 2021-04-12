package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.LocationDao;
import org.academiadecodigo.hackathon.persistence.model.Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDaoImpl extends GenericDao<Location> implements LocationDao {

    public LocationDaoImpl() {
        super(Location.class);
    }
}
