package com.tenpo.demo.controller.impl;

import com.tenpo.demo.controller.SignUpController;
import com.tenpo.demo.dao.impl.SignUpDaoImpl;
import com.tenpo.demo.entities.User;
import com.tenpo.demo.exception.RecordNotFoundException;
import com.tenpo.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"*"})
public class SignUpControllerImpl implements SignUpController {
    @Autowired
    private SignUpDaoImpl signupDao;

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/addUser")
    @Override
    public String addUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return signupDao.persist(user);
    }
    @RequestMapping("/deleteUser/{userId}")
    @Override
    public String deleteUser(@PathVariable String userId){
            return signupDao.delete(userId);
    }
    @RequestMapping("/getUser/{userId}")
    @Override
    public User getUser(@PathVariable String userId){
        return userRepo.findByUserId(userId)
                .orElseThrow(() -> new RecordNotFoundException("Entered User'" + userId + "' does no exist"));
    }
    @RequestMapping("/getAllUsers")
    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

}
