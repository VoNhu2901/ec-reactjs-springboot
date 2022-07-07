package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.entities.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Ordered, Integer> {
    List<Ordered> findByAccount(Account acc);
}
