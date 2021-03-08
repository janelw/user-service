package com.user.user.auth;

import com.user.user.model.user;
import com.user.user.repository.userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private userrepo ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = ur.getUserByUsername(username);
        AppUserDetails userDetails = null;
        if (user != null) {
            userDetails = new AppUserDetails();
            userDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User does not exist with name: " + username);
        }
        return userDetails;
    }

}
