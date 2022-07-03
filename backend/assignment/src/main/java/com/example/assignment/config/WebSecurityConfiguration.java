package com.example.assignment.config;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.assignment.services.impl.UserServiceImpl;

import static com.example.assignment.config.WebUserRole.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;;

    private final UserServiceImpl userServiceImpl;

    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/v*/registration/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();

    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    // UserDetails user = User.builder()
    // .username("client")
    // .password(passwordEncoder.encode("password"))
    // .roles(CLIENT.name())
    // .build();
    // UserDetails user2 = User.builder()
    // .username("admin")
    // .password(passwordEncoder.encode("password"))
    // .roles(ADMIN.name())
    // .build();
    // UserDetails user3 = User.builder()
    // .username("admintrainee")
    // .password(passwordEncoder.encode("password"))
    // .roles(ADMINTRAINEE.name())
    // .build();
    // return new InMemoryUserDetailsManager(user, user2, user3);
    // }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userServiceImpl);
        return daoAuthenticationProvider;
    }

    // write method use daoAuthenticationProvider() to set the authentication manager provider
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(new DaoAuthenticationProvider[] { daoAuthenticationProvider() });
    }

    



}
