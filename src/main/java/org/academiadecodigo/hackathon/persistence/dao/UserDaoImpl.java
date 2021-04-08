package org.academiadecodigo.hackathon.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDao<User> implements UserDao{

        public UserDaoImpl() {
            super(User.class);
        }
    }
}
