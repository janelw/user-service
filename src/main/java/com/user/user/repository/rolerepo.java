package com.user.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.user.user.model.*;
public interface rolerepo extends JpaRepository<role,Integer>{
    role findbyRole(String role);
}
