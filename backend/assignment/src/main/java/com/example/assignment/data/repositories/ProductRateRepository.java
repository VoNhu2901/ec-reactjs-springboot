package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Product;
import com.example.assignment.data.entities.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRateRepository extends JpaRepository<ProductRate, Integer> {
    List<ProductRate> findByStatus(boolean status);

    Optional<ProductRate> findByAccIdAndProduct(int accId, Product optional);
}
