package com.example.assignment.data.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.assignment.services.impl.UserDetailsImpl;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDetailsImpl, Long> {


  //write findByEmail method
  Optional<UserDetailsImpl> findByEmail(String email);
  
  @Transactional
  @Modifying
  @Query("UPDATE UserDetailsImpl a " +
      "SET a.enabled = TRUE WHERE a.email = ?1")
  int enableAppUser(String email);

}
