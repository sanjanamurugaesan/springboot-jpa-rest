package com.tenpo.demo.dao;

import com.tenpo.demo.entities.User;

public interface LoginDao {
    boolean validateLogin(User user);
    int updateLoginStatus(String userId, String status);
}
