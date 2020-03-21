package com.tenpo.demo.controller;

import com.tenpo.demo.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SignUpController {
    String addUser(@RequestBody User user);
    String deleteUser(@PathVariable String userId);
    User getUser(@PathVariable String userId);
    List<User> getAllUsers();
}
