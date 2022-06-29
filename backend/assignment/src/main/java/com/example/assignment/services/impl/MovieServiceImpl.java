package com.example.assignment.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.Movie;
import com.example.assignment.data.repositories.MovieRepository;
import com.example.assignment.dto.request.MovieUpdateDTO;
import com.example.assignment.dto.response.MovieResponseDTO;
import com.example.assignment.exceptions.ResourceFoundException;
import com.example.assignment.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
  private final MovieRepository movieRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
    this.movieRepository = movieRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<Movie> getAllMovies() {
    return this.movieRepository.findAll();
  }

  @Override
  public MovieResponseDTO getMovieById(Long id) {
    return modelMapper.map(
        this.movieRepository.findById(id).orElseThrow(() -> new ResourceFoundException("Movie Not Found")),
        MovieResponseDTO.class);
  }
  
  @Override
  public MovieResponseDTO createMovie(MovieUpdateDTO dto) {
    Movie movie = modelMapper.map(dto, Movie.class);
    Movie saveMovie = movieRepository.save(movie);
    return modelMapper.map(saveMovie, MovieResponseDTO.class);
  }

  @Override
  public MovieResponseDTO updateMovie(Long id, MovieUpdateDTO dto) {
    Movie movie = modelMapper.map(dto, Movie.class);
    movie.setId(id);
    Movie saveMovie = movieRepository.save(movie);
    return modelMapper.map(saveMovie, MovieResponseDTO.class);
  }

  @Override
  public MovieResponseDTO deleteMovie(Long id) {
    Movie movie = this.movieRepository.findById(id)
        .orElseThrow(() -> new ResourceFoundException("Movie Not Found"));
    this.movieRepository.delete(movie);
    return modelMapper.map(movie, MovieResponseDTO.class);
  }

  @Override
  public List<Movie> getMovieByTitle(String title) {
    return this.movieRepository.findByTitle(title);
  }
}
