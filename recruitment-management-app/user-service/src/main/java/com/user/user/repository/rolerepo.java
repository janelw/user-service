package com.user.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.user.model.*;

@Repository
public interface rolerepo extends JpaRepository<role, Integer> {

    @Query(value = "SELECT roleid from users u WHERE u.user_id = :user_id", nativeQuery = true)
    role findRoleById(@Param("user_id") Integer id);

}
