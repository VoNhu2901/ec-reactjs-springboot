package com.example.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.data.models.Actor;
import com.example.assignment.data.repositories.ActorRepository;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {
  // @Autowired
  // private ActorRepository actorRepository;

  // @GetMapping
  // public List<Actor> getAllActors() {
  //   return actorRepository.findAll();
  // }
}
