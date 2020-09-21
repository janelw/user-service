package com.user.user.service;

import java.sql.Timestamp;
import java.util.List;

import com.user.user.model.role;
import com.user.user.model.user;
import com.user.user.repository.userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.digest.*;

public class userservice {
    
    @Autowired
    private userrepo ur;

    public user create(user userr){
        userr.setPassWord(DigestUtils.sha256Hex(userr.getPassWord()));;
        userr.setCreated(new Timestamp(System.currentTimeMillis()));
        return ur.save(userr);
    }

    public List<user> findAll(){
        return ur.findAll();
    }

    public user findUserByUsername(String username){
        return ur.findByUsername(username);
    }

    public int findIdByUsername(String username){
        return findUserByUsername(username).getUserId();
    }

    public boolean updatePasswordById(int user_id, String password){
        if (ur.existsById(user_id)){
            user userr = ur.findById(user_id).get();
            userr.setPassWord(DigestUtils.sha256Hex(password));
            ur.save(userr);
            return true;
        }else{
            return false; 
        }
    }

    public boolean updateLastNameById(int user_id, String lastName){
        if(ur.existsById(user_id)){
            user userr = ur.findById(user_id).get();
            userr.setLastName(lastName);
            ur.save(userr);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateRoleById(int user_id, role user_role){
        if(ur.existsById(user_id)){
            user userr = ur.findById(user_id).get();
            userr.setRole(user_role);
            ur.save(userr);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteUserById(int user_id){
        if(ur.existsById(user_id)){
            ur.deleteById(user_id);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteUserByUser(user userr){
        if(ur.existsById(userr.getUserId())){
            ur.delete(userr);
            return true;
        }else{
            return false;
        }
    }
}
