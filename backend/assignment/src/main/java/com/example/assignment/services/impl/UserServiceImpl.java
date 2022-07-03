package com.example.assignment.services.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.ConfirmationToken;
import com.example.assignment.data.repositories.AccountRepository;
import com.example.assignment.data.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService {

  private final static String USERNAME_NOT_FOUND_MSG = "User with email %s not found";
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final ConfirmationTokenServiceImpl confirmTokenServiceImpl;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // .map(user -> new UserDetailsImpl(user.getName(), user.getEmail(),
    // user.getPassword(), user.getRole(), user.getLocked(), user.getEnabled()))
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_MSG, email)));
  }

  public String signUpUser(UserDetailsImpl userDetails) {
    userRepository.findByEmail(userDetails.getEmail()).ifPresent(user -> {
      throw new IllegalArgumentException("User with email " + userDetails.getEmail() + " already exists");
    });
    userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
    userRepository.save(userDetails);

    //TODO: Send confirm token
    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmToken = new ConfirmationToken(
        token,
        LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15),
        userDetails);

    confirmTokenServiceImpl.saveConfirmToken(confirmToken);

    // TODO: Send email

    return token;
  }
  
  public int enableAppUser(String email) {
    return userRepository.enableAppUser(email);
  }

}
