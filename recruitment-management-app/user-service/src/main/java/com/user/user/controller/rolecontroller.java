package com.user.user.controller;

import java.util.List;
import java.util.Optional;

import com.user.user.service.roleservice;
import com.user.user.model.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class rolecontroller {   
    
    @Autowired
    private roleservice rs;

    @PostMapping("/create")
    public role create(@RequestBody role role){
        return rs.create(role);
    }
    
    @GetMapping("/all")
    public List<role> getAllRole(){
        return rs.findAll();
    }

    @GetMapping("/getById/{id}")
    public role findRoleById(@PathVariable int user_id){
        return rs.findRoleById(user_id);
    }

    // @GetMapping("getByRole/{role}")
    // public role getByRole(@PathVariable String role){
    //     return rs.findByRole(role);
    // }

    @PostMapping("/updaterole/{role}")
    public role updateRole(@RequestBody role role){
        return rs.updateRole(role);
    }


    



    
}
