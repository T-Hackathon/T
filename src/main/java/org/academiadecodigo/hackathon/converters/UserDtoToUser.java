package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.UserDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.academiadecodigo.hackathon.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User convert(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setUserName(userDto.getUserName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setCity(userDto.getCity());

        return user;
    }
}

