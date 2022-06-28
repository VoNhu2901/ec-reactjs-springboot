package com.example.assignment.services;

import java.util.List;

import com.example.assignment.data.entities.Movie;
import com.example.assignment.dto.request.MovieUpdateDTO;
import com.example.assignment.dto.response.MovieResponseDTO;

public interface MovieService {

  List<Movie> getAllMovies();

  MovieResponseDTO getMovieById(Long id);

  MovieResponseDTO createMovie(MovieUpdateDTO dto);

  MovieResponseDTO updateMovie(Long id, MovieUpdateDTO dto);

  MovieResponseDTO deleteMovie(Long id);

  List<Movie> getMovieByTitle(String title);
  
}
