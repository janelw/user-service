package com.user.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.user.user.model.role;

import com.user.user.repository.rolerepo;

@Service
public class roleservice {

    @Autowired
    private rolerepo rr;

    public role create(role role) {
        return rr.save(role);
    }

    public List<role> findAll() {
        return rr.findAll();

    }

    public role findRoleById(int id) {
        return rr.findRoleById(id);
    }

    public role updateRole(role role) {
        return rr.save(role);
    }

}
