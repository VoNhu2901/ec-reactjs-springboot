package com.example.assignment.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.data.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
  //all crud data base methods are inherited from JpaRepository


  
}
