package com.example.assignment.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.assignment.config.WebUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(CLIENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();

    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("client")
                .password(passwordEncoder.encode("password"))
                .roles(CLIENT.name())
                .build();
        UserDetails user2 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();
        UserDetails user3 = User.builder()
                .username("admintrainee")
                .password(passwordEncoder.encode("password"))
                .roles(ADMINTRAINEE.name())
                .build();
        return new InMemoryUserDetailsManager(user, user2, user3);
    }
}
