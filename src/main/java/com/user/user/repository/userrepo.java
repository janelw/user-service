package com.user.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.user.model.*;
public interface userrepo extends JpaRepository<user, Integer> {
        user findByUsername(String username);
}
