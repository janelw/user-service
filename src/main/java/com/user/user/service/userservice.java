package com.user.user.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Optional;
// import com.user.user.model.ConfirmationToken;
import com.user.user.model.role;
import com.user.user.model.user;
import com.user.user.repository.rolerepo;
import com.user.user.repository.userrepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;

import org.apache.commons.codec.digest.*; 


@Service
public class userservice {
    
    @Autowired
    private userrepo ur;

    @Autowired 
    private rolerepo rr;

    @Autowired
    private JavaMailSender mailsender;

    // @Autowired
    // private confirmationtokenservice confirmationTokenService;

    // @Autowired
    // emailservice emailService;



    public void register(user users){
    
    // String randomCode = RandomString.make(64);
    // users.setVerificationcode(randomCode);
    users.setEnabled(false);
    users.setCreated(new Timestamp(System.currentTimeMillis()));
    
    ur.save(users);
    

    }

    public void sendVerificationEmail(user user){
        String subject = "Please verify your registration";
        String senderName = "Recruitment";
        String mailContent = "<p>Dear" + user.getFirstName() + ",</p>";
        mailContent += "<p> Please click the link below to verify your email</p>";
        mailContent += "<p> Thank you <br> Registration Team</p>";
        
    }



    public user findUserByEmail(String email){
        return ur.getUserByEmail(email);
    }

    
    public List<user> findAll() {
        return ur.findAll();
    }

    // public user findUserByUsername(String username){
    //     return ur.findByUsername(username);
    // }

    // public int findIdByUsername(String username){
    //     return findUserByUsername(username).getUserId();
    // }

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

    // public boolean updateRoleById(int user_id, role user_role){
    //     if(ur.existsById(user_id)){
    //         user userr = ur.findById(user_id).get();
    //         userr.setRole(user_role);
    //         ur.save(userr);
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }

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
