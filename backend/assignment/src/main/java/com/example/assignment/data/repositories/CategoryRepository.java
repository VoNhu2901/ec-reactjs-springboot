package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  
  // @Query("SELECT m FROM Category m WHERE m.name LIKE %?1%")
  List<Category> findByName(String name);
}
