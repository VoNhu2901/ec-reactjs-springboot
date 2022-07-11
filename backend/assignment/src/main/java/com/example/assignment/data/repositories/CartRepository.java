package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Account;
import com.example.assignment.data.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    Cart findByAccountAndActive(Account account, boolean active);
}
