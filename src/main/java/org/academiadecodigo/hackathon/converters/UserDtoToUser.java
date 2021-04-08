package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.javabank.command.UserDto;
import org.academiadecodigo.javabank.persistence.model.User;
import org.academiadecodigo.javabank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    private UserService UserService;

    @Autowired
    public void setUserService(UserService UserService) {
        this.UserService = UserService;
    }

    @Override
    public User convert(UserDto UserDto) {

        User User = (UserDto.getId() != null ? UserService.get(UserDto.getId()) : new User());

        User.setFirstName(UserDto.getFirstName());
        User.setLastName(UserDto.getLastName());
        User.setEmail(UserDto.getEmail());
        User.setPhone(UserDto.getPhone());

        return User;
    }
}

