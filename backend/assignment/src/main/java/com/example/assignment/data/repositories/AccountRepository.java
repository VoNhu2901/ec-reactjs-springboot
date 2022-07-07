package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    /**
     * find user have username
     * 
     * @param username username to compare
     * @return Optional<Account>
     */
    Optional<Account> findByUsername(String username);

    /**
     * Check existing of username
     * 
     * @param username username to check
     * @return true: if exist else false
     */
    Boolean existsByUsername(String username);
}
