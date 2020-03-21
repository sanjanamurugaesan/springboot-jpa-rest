package com.tenpo.demo.controller;

import com.tenpo.demo.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginController {
    String login(@RequestBody User loginDetails);
    String logout(@PathVariable String userId);
}
