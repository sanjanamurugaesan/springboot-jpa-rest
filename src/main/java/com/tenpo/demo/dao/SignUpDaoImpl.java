package com.tenpo.demo.dao;

import com.tenpo.demo.entities.User;
import com.tenpo.demo.exception.RecordNotFoundException;
import com.tenpo.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SignUpDaoImpl {
    @Autowired
    UserRepository userRepo;

    @PersistenceContext
    private EntityManager entityManager;




   @Transactional
    public String persist(User user) {
        try{
            user.setPassword(user.getPassword());
            this.entityManager.persist(user);
            return "New Registration added successfully";
        } catch(Exception e){
            e.printStackTrace();
            return "DataBase Error Occured. Please try after some time";
        }
    }
    @Transactional
    public String delete(String userId){
       Optional<User> entity = userRepo.findByUserId(userId);
       this.entityManager.remove(entity
               .orElseThrow(() -> new RecordNotFoundException("Entered User'" + userId + "' does no exist")));
       return "Deleted successfully";
    }
}
