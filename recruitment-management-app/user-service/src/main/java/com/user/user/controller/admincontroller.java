package com.user.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.user.user.model.user;
import com.user.user.repository.userrepo;
import com.user.user.service.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class admincontroller {
    
    @Autowired
    private userservice us;

    
    @Autowired
    private userrepo ur;
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/all")
    public List<user> getAllUser() {

        return us.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/adminpage")
    public String admin() {
        return "Hello Admin!";
    }

    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int userId) {
        user user = us.findUserById(userId);
        ur.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
