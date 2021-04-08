package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    List<User>  list();

    User save(User user);
}
