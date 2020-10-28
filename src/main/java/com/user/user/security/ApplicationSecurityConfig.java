package com.user.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.user.user.filters.JwtRequestFilter;;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs/**");
        web.ignoring().antMatchers("/swagger.json");
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/swagger-resources/**");
        web.ignoring().antMatchers("/webjars/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable().cors()
        .and()
        .authorizeRequests().antMatchers("/user/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/authenticate/**").permitAll()
        .and()
        .authorizeRequests().antMatchers("/public/**").permitAll()
        .and().authorizeRequests().antMatchers("/cand/**").hasAnyRole("CAND")
        .and().authorizeRequests().antMatchers("/recr/**").hasAnyRole("HRECR")
        .and().authorizeRequests().antMatchers("/panel/**").hasAnyRole("PANEL")
        .and().authorizeRequests().antMatchers("/inter/**").hasAnyRole("INTER")
        .and().authorizeRequests().antMatchers("/hr/**").hasAnyRole("HR")
        .and().authorizeRequests().antMatchers("/admin/**").authenticated().anyRequest().hasAnyRole("ADMIN")
        .and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // .and()
        // .formLogin().permitAll();

    }

}
