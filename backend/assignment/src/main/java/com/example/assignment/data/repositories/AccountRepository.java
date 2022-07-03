package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  


}
