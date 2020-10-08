package com.user.user.controller;

import com.user.user.service.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.user.service.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.user.user.model.ConfirmationToken;
import com.user.user.model.role;
import com.user.user.model.user;
import com.user.user.repository.confirmtokenrepo;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private userservice us;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // @Autowired
    // private confirmationtokenservice cts;

    @Autowired
    confirmtokenrepo cr;

    @Autowired
    private emailservice es;

    // @ModelAttribute("user") //When User submits form, this is where the user data is stored to be used in the POST
    // public user newuser(){
    //     return new user();
    // }

    // @GetMapping("/register")
    // public ModelAndView registerForm(ModelAndView mv){
    //     mv.setViewName("registration");
    //     mv.addObject("user", new user());
    //     return mv;
    // }
    @PostMapping("/register")
    public void create(@RequestBody user users) {  //@Model Attribute is being used in place of response body here 

            String pwd = users.getPassWord();
            String encryptPwd = passwordEncoder.encode(pwd);
            users.setPassWord(encryptPwd);
            us.register(users);


            es.sendSimpleEmail(users.getEmail(), "Confirmation Email", "To Confirm your email click here:");

            //create a new confirmation token 
            // ConfirmationToken confirmationToken = new ConfirmationToken(users);
            // cr.save(confirmationToken);

            // SimpleMailMessage mailMessage = new SimpleMailMessage();
            // mailMessage.setTo(users.getEmail());
            // mailMessage.setSubject("Complete Registration!");
            // mailMessage.setFrom("jgwsoftdev@gmail.com");
            // mailMessage.setText("To Confirm your account, please click here: "
            // + "http://locahost:8080/activation?token" +confirmationToken.getConfirmationToken());

            // es.sendEmail(mailMessage);

      
        }
            
       
        
    

    // @GetMapping("/activation")
    // public ModelAndView activation(ModelAndView modelAndView, @RequestParam("token") String token) {
        
    //     ConfirmationToken confirmtoken = cts.findByToken(token);

    //     if(token !=null){
    //         cts.confirmUser(confirmtoken);
    //         modelAndView.setViewName("accountVerified");
    //     }else{
    //         modelAndView.addObject("message", "The link is invalid or broken!");
    //         modelAndView.setViewName("error");
    //     }

    //     return modelAndView;

    
    // }

    
    @GetMapping("/all")
    public List<user> getAllUser() {
        return us.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/adminpage")
    public String admin() {
        return "<h2>Hello Admin!</h2>";
    }

    // @GetMapping("/hr")
    // public String hr() {
    //     return "<h2>Hello hr!</h2>";
    // }

    // @PreAuthorize("hasAnyRole('CAND')")
    // @GetMapping("/cand/candpage")
    // public String cand() {
    //     return "<h2>Hello Candidate!</h2>";
    // }

    // @GetMapping("/intr")
    // public String intr() {
    //     return "<h2>Hello Interviewer!</h2>";
    // }

    // @GetMapping("/recru")
    // public String recru() {
    //     return "<h2>Hello Recruter!</h2>";
    // }

    // @GetMapping("/sched")
    // public String sched() {
    //     return "<h2>Hello Scheduler!</h2>";
    // }

    // @GetMapping("/panel")
    // public String panel() {
    //     return "<h2>Hello Panelist!</h2>";
    // }

    // @GetMapping("getById/{id}")
    // public user getUserById(@PathVariable(""))

}
