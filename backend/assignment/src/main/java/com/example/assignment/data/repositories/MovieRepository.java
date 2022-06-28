package com.example.assignment.data.repositories;

import com.example.assignment.data.entities.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  @Query("SELECT m FROM Movie m WHERE m.title LIKE %?1%")
  List<Movie> findByTitle(String title);

}
