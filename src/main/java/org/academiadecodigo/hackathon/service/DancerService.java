package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.model.Dancer;

import java.util.List;

public interface DancerService {

    Dancer get(Integer id);

    List<Dancer>  list();

    Dancer save(Dancer dancer);
}
