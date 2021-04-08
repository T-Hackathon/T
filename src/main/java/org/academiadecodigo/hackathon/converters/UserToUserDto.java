package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.UserDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserToUserDto {


    public UserDto convert(User User) {

        UserDto UserDto = new UserDto();
        UserDto.setId(User.getId());
        UserDto.setUserName(User.getUserName());
        UserDto.setAge(User.getAge());
        UserDto.setEmail(User.getEmail());
        UserDto.setPhone(User.getPhone());
        UserDto.setPassword(User.getPassword());

        return UserDto;
    }
}
