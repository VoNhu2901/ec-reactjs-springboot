package com.example.assignment.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {
  @Id
  @SequenceGenerator(name = "moive_squence", sequenceName = "moive_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moive_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false, columnDefinition = "TEXT")
  private String title;

  @Column(name = "description", nullable = true, columnDefinition = "TEXT")
  private String description;

  @Column(name = "release_year", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime releaseYear;

  //////
  private Long languageId;

  @Column(name = "rental_duaration", nullable = false)
  private Integer rentalDuaration;

  @Column(name = "length", nullable = false)
  private Integer length;

  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Column(name = "url_image", nullable = false, columnDefinition = "TEXT")
  private String urlImage;

  @Column(name = "url_trailer", nullable = false, columnDefinition = "TEXT")
  private String urlTrailer;

  @Column(name = "last_update", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime lastUpdate;

}
