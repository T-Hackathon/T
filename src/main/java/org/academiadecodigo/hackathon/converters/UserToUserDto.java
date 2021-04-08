package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.javabank.command.UserDto;
import org.academiadecodigo.javabank.persistence.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {


    @Override
    public UserDto convert(User User) {

        UserDto UserDto = new UserDto();
        UserDto.setId(User.getId());
        UserDto.setFirstName(User.getFirstName());
        UserDto.setLastName(User.getLastName());
        UserDto.setEmail(User.getEmail());
        UserDto.setPhone(User.getPhone());

        return UserDto;
    }
}
