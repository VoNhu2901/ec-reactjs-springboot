package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    //all crud data base methods are inherited from JpaRepository


}
