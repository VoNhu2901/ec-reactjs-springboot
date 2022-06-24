package com.example.assignment.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.data.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
