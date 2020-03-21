package com.tenpo.demo.dao.impl;

import com.tenpo.demo.util.Constants;
import com.tenpo.demo.entities.MathOperation;
import com.tenpo.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MathOperationDaoImpl {
    @Autowired
    UserRepository userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String persist(MathOperation sumEntity){
        try{
            this.entityManager.persist(sumEntity);
            return Constants.SUCCESS;
        } catch(Exception e){
            e.printStackTrace();
            return Constants.ERROR;
        }
    }


}
