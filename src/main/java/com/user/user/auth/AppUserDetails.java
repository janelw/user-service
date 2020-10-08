package com.user.user.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.user.user.model.role;
import com.user.user.model.user;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDetails implements UserDetails {


    private user user;
 
        

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole_type()))
       .collect(Collectors.toList());
    
       
        
    }

    @Override
    public String getPassword() {
        return user.getPassWord();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public user getUser() {
        return this.user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    
}
