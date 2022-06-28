package com.example.assignment.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.data.entities.Movie;
import com.example.assignment.dto.request.MovieUpdateDTO;
import com.example.assignment.dto.response.MovieResponseDTO;
import com.example.assignment.services.MovieService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  List<Movie> getMovies() {
    return this.movieService.getAllMovies();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  MovieResponseDTO getMovieById(@PathVariable("id") Long id) {
    return this.movieService.getMovieById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  MovieResponseDTO createMovie(@RequestBody MovieUpdateDTO dto) {
    return this.movieService.createMovie(dto);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  MovieResponseDTO updateMovie(@PathVariable("id") Long id, @RequestBody MovieUpdateDTO dto) {
    return this.movieService.updateMovie(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  MovieResponseDTO deleteMovie(@PathVariable("id") Long id) {
    return this.movieService.deleteMovie(id);
  }

}
