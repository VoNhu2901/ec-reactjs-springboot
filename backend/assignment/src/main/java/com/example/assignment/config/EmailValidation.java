package com.example.assignment.config;

import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;

@Service
public class EmailValidation implements Predicate<String>{

  @Override
  public boolean apply(String s) {
    return true;
  }

//  @Override
//  public boolean test(String input) {
//    return Predicate.super.test(input);
//  }

 
  
}
