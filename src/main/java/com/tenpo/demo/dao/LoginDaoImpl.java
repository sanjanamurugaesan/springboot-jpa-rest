package com.tenpo.demo.dao;

import com.tenpo.demo.entities.User;
import com.tenpo.demo.repo.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Service
public class LoginDaoImpl {
    @Autowired
    private UserRepository userRepo;

    private static Log logger = LogFactory.getLog(LoginDaoImpl.class);;

    @PersistenceContext
    private EntityManager entityManager;

    public boolean validateLogin(User user){
       TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.userId = :userId", User.class);
        query.setParameter("userId", user.getUserId());
        try{
            User userEntity = query.getSingleResult();
            if(userEntity != null) return true; else return false;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Transactional
    public int updateLoginStatus(String userId, String status){
        return userRepo.updateLoginStatus(userId, status);
    }

}
