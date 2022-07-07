package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.CartItem;
import com.example.assignment.data.entities.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
    CartItem findByCartIdAndProId(int cartId, int proId);
}
