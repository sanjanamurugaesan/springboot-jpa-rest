package com.tenpo.demo.controller;

import com.tenpo.demo.util.Constants;
import com.tenpo.demo.dao.LoginDaoImpl;
import com.tenpo.demo.entities.User;
import com.tenpo.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin({"*"})
public class LoginControllerImpl {
    @Autowired
    private LoginDaoImpl loginDao;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/login")
    public String login(@RequestBody User loginDetails){
        Optional<User> user = userRepo.findByUserId(loginDetails.getUserId());
        String encodedPassword = user.get().getPassword();
        if(user.isPresent()){
            PasswordEncoder matcher = new BCryptPasswordEncoder();
            System.out.println(matcher.matches(loginDetails.getPassword(),encodedPassword));
            if(matcher.matches(loginDetails.getPassword(),encodedPassword)){
                int status = loginDao.updateLoginStatus(loginDetails.getUserId(), "Y");
                if(status == 1) return Constants.LOGIN;
                else  return Constants.ERROR;
            }
            return Constants.AUTHENTICATION_FAILED;
        } else {
            return Constants.USER_NOT_EXISTS;
        }
    }
    @RequestMapping("/logout/{userId}")
    public String logout(@PathVariable String userId){
            int status = loginDao.updateLoginStatus(userId, "N");
            if(status ==1) return Constants.LOGOUT;
            else return Constants.ERROR;
    }
}
