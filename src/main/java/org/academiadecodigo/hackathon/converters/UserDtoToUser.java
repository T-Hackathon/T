package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.UserDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.academiadecodigo.hackathon.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser {

    private UserService UserService;

    @Autowired
    public void setUserService(UserService UserService) {
        this.UserService = UserService;
    }

    public User convert(UserDto UserDto) {

        User User = (UserDto.getId() != null ? UserService.get(UserDto.getId()) : new User());

        User.setUserName(UserDto.getUserName());
        User.setAge(UserDto.getAge());
        User.setEmail(UserDto.getEmail());
        User.setPhone(UserDto.getPhone());
        User.setPassword(UserDto.getPassword());

        return User;
    }
}

