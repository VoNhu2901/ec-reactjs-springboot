package com.example.assignment.config;

import com.example.assignment.security.jwt.JwtAuthEntryPoint;
import com.example.assignment.security.jwt.JwtAuthTokenFilter;
import com.example.assignment.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;
    private final JwtUtils jwtUtils;

    @Autowired
    public WebSecurityConfig(JwtAuthEntryPoint jwtAuthEntryPoint, JwtUtils jwtUtils,
                             UserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.jwtAuthEntryPoint = jwtAuthEntryPoint;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public JwtAuthTokenFilter authenticationJwtAuthTokenFilter() {
        return new JwtAuthTokenFilter(jwtUtils, userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(authenticationJwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/category", "/api/v1/product").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/product/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/api/v1/product/**", "/api/v1/rate/**").hasAnyAuthority("ADMIN")
                .antMatchers( "/api/v1/image/**", "/api/v1/account").hasAnyAuthority("ADMIN")
                .antMatchers("/api/v1/cart", "/api/v1/cart/**", "/api/v1/account/**", "/api/v1/rate").hasAnyAuthority("USER")

                .anyRequest().permitAll();

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html",
                "/swagger-ui/**",
                "/api-docs/**", "/api-doc-ui");
    }

}
