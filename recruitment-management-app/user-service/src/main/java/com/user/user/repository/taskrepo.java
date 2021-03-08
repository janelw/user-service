package com.user.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.user.user.model.*;

@Repository
public interface taskrepo extends JpaRepository<tasks, Integer>{
    
}
