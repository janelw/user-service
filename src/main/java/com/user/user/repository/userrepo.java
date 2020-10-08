package com.user.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.user.user.model.*;
@Repository
public interface userrepo extends JpaRepository<user, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.user_name = :user_name", nativeQuery = true)
    user getUserByUsername(@Param("user_name") String username);
    

    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
    user getUserByEmail(@Param("email") String email);
}
