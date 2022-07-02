package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

//    @Transactional
//    @Modifying
//    @Query( "UPDATE account a " +
//            "SET a.enabled = :enabled WHERE a.id = :id")
//    void changeUserAccountStatus(@Param("id") Long id, @Param("locked") Boolean isEnabled);



}
