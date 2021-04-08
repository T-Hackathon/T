package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.UserDao;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDao<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}
