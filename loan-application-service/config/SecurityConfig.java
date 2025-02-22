package de.smava.homework.auth.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private  BCryptPasswordEncoder passwordEncoder;
	@Autowired
    private  UserDetailsService userDetailsService;
	@Autowired
    private  AuthenticationManagerBuilder authenticationBuilder;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        authenticationBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return super.authenticationManagerBean();
    }
}