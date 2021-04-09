package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.DancerDto;
import org.academiadecodigo.hackathon.persistence.model.Dancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.academiadecodigo.hackathon.service.DancerService;
import org.springframework.stereotype.Component;

@Component
public class DancerDtoToUser {

    private DancerService dancerService;

    @Autowired
    public void setUserService(DancerService dancerService) {
        this.dancerService = dancerService;
    }

    public Dancer convert(DancerDto dancerDto) {

        Dancer dancer = (dancerDto.getId() != null ? dancerService.get(dancerDto.getId()) : new Dancer());

        dancer.setUserName(dancerDto.getUserName());
        dancer.setAge(dancerDto.getAge());
        dancer.setEmail(dancerDto.getEmail());
        dancer.setPhone(dancerDto.getPhone());
        dancer.setPassword(dancerDto.getPassword());
        dancer.setCity(dancerDto.getCity());

        return dancer;
    }
}

