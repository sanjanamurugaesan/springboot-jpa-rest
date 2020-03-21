package com.tenpo.demo.dao;

import com.tenpo.demo.entities.User;

public interface SignUpDao {
    String persist(User user);
    String delete(String userId);
}
