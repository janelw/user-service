package com.user.user.repository;

import com.user.user.model.ConfirmationToken;
import com.user.user.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface confirmtokenrepo extends JpaRepository<ConfirmationToken, String> {

    // @Query(value = "SELECT * FROM confirmtoken c WHERE c.confirmid = :confirmid", nativeQuery = true)
    // Boolean deleteConfirmationTokenById(@Param("confirmid") Long id);
    
    // @Query(value = "SELECT * FROM users c WHERE c.token = :token", nativeQuery = true)
    // ConfirmationToken findByToken(String token);

    // @Query(value = "SELECT * FROM confirmtoken c WHERE c.userid = :userid", nativeQuery = true)
    // ConfirmationToken findByUser(@Param("userid") user users);



}
