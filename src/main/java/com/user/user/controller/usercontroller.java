package com.user.user.controller;

import com.user.user.service.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.user.service.userservice;

import java.util.List;

import com.user.user.model.user;
public class usercontroller {
    
    @Autowired
    private userservice us;

    @PostMapping("/create")
    public user create(@RequestBody user userr){
        return us.create(userr);

    }

    @GetMapping("/all")
    public List<user> getAllUser(){
        return us.findAll();
    }

    // @GetMapping("getById/{id}")
    // public Optional<Jrad

}
