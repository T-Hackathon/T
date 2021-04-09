package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.DancerDto;
import org.academiadecodigo.hackathon.persistence.model.Dancer;
import org.springframework.stereotype.Component;


@Component
public class DancerToUserDto {


    public DancerDto convert(Dancer Dancer) {

        DancerDto DancerDto = new DancerDto();
        DancerDto.setId(Dancer.getId());
        DancerDto.setUserName(Dancer.getUserName());
        DancerDto.setAge(Dancer.getAge());
        DancerDto.setEmail(Dancer.getEmail());
        DancerDto.setPhone(Dancer.getPhone());
        DancerDto.setCity(Dancer.getCity());
        DancerDto.setPassword(Dancer.getPassword());

        return DancerDto;
    }
}
