package com.user.user.controller;

import com.user.user.service.userservice;
import com.user.user.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.user.service.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.user.user.auth.MyUserDetailsService;
import com.user.user.model.AuthenticationRequest;
import com.user.user.model.AuthenticationResponse;
import com.user.user.model.role;
import com.user.user.model.user;
import com.user.user.repository.userrepo;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private userservice us;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private emailservice es;

    @Autowired
    private userrepo ur;

    @Autowired
    private AuthenticationManager authenticationManager; // authenticates a new username and password token

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    // @ModelAttribute("user") //When User submits form, this is where the user data
    // is stored to be used in the POST
    // public user newuser(){
    // return new user();
    // }

    // @GetMapping("/register")
    // public ModelAndView registerForm(ModelAndView mv){
    // mv.setViewName("registration");
    // mv.addObject("user", new user());
    // return mv;
    // }

    @PostMapping("/register")
    public String create(@RequestBody user users) {

        String pwd = users.getPassWord();
        String encryptPwd = passwordEncoder.encode(pwd);
        users.setPassWord(encryptPwd);
        user registereduser = us.register(users);

        es.sendSimpleEmail(users.getEmail(), "Confirmation Email",
                "To confirm your email address, use this verification code: " + registereduser.getVerificationcode());
        return "Verification code sent!";
    }

    @GetMapping("/activation")
    public String activation(@RequestParam String verificationcode) {

        user confirmeduser = ur.getUserByToken(verificationcode);

        confirmeduser.setEnabled(true);

        ur.save(confirmeduser);

        return "Your account has been confirmed!";

    }

    @GetMapping("/all")
    public List<user> getAllUser() {
        return us.findAll();
    }

    @PostMapping("/authenticate") // takes in request for authentication, which contains the post body UserDetails                            // as request body
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e); // if credentials are incorrect
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails); // creates token

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/adminpage")
    public String admin() {
    return "<h2>Hello Admin!</h2>";
    }

    // @GetMapping("/hr")
    // public String hr() {
    // return "<h2>Hello hr!</h2>";
    // }

    @PreAuthorize("hasAnyRole('CAND')")
    @GetMapping("/cand/candpage")
    public String cand() {
    return "<h2>Hello Candidate!</h2>";
    }

    // @GetMapping("/intr")
    // public String intr() {
    // return "<h2>Hello Interviewer!</h2>";
    // }

    // @GetMapping("/recru")
    // public String recru() {
    // return "<h2>Hello Recruter!</h2>";
    // }

    // @GetMapping("/sched")
    // public String sched() {
    // return "<h2>Hello Scheduler!</h2>";
    // }

    // @GetMapping("/panel")
    // public String panel() {
    // return "<h2>Hello Panelist!</h2>";
    // }

    // @GetMapping("getById/{id}")
    // public user getUserById(@PathVariable(""))

}
