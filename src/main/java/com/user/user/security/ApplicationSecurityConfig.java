package com.user.user.security;

// import com.user.user.auth.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
         return new BCryptPasswordEncoder(); 
    } 
     


  @Autowired 
  private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
        .csrf().disable();
        http
        .authorizeRequests().antMatchers("/rest/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/user/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/cand/**").hasAnyRole("CAND")
        .and()
        .authorizeRequests().antMatchers("/recr/**").hasAnyRole("RECR")
        .and()
        .authorizeRequests().antMatchers("/panel/**").hasAnyRole("PANEL")
        .and()
        .authorizeRequests().antMatchers("/inter/**").hasAnyRole("INTER")
        .and()
        .authorizeRequests().antMatchers("/hr/**").hasAnyRole("HR")
        .and()
        .authorizeRequests().antMatchers("/admin/**").authenticated().anyRequest().hasAnyRole("ADMIN");
        // .and()
        // .formLogin().permitAll();
   
    }




    
}

