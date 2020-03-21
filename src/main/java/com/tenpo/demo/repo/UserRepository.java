package com.tenpo.demo.repo;

import com.tenpo.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    Optional<User> findByUserId(String userId);
    @Modifying
    @Query("UPDATE User u SET u.isLoggedIn=:isLoggedIn WHERE u.userId=:userId")
    int updateLoginStatus(@Param("userId") String userId, @Param("isLoggedIn") String isLoggedIn);

}
