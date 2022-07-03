package com.example.assignment.data.repositories;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.assignment.data.entities.ConfirmationToken;
import com.google.common.base.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

  
      
  Optional<ConfirmationToken> findByToken(String token);

  @Transactional
  @Modifying
  @Query("UPDATE ConfirmationToken c " +
  "SET c.confirmedAt = ?2 " +
  "WHERE c.token = ?1")
  int updateConfirmedAt(String token,
  LocalDateTime confirmedAt);

}
