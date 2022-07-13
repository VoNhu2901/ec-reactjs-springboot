package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStatus(Boolean status);

    List<Product> findByCategoryAndStatus(Category cate, Boolean status);
}
