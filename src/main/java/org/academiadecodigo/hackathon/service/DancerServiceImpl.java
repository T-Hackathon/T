package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.persistence.DancerDao;
import org.academiadecodigo.hackathon.persistence.model.Dancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DancerServiceImpl implements DancerService {
    //Fields
    private DancerDao dancerDao;

    @Autowired
    public void setUserDao(DancerDao dancerDao) {
        this.dancerDao = dancerDao;
    }

    @Override
    public Dancer get(Integer id) {
        return dancerDao.findById(id);
    }

    @Override
    public List<Dancer> list() {
        return dancerDao.findAll();
    }

    @Transactional
    @Override
    public Dancer save(Dancer dancer) {
        return dancerDao.saveOrUpdate(dancer);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        dancerDao.delete(id);
    }

}
