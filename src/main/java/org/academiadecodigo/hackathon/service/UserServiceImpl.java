package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.UserDao;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    //Fields
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }
}
