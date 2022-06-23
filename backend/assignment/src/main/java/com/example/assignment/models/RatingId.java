package com.example.assignment.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RatingId implements  Serializable{
  private static final long serialVersionUID = 1L;

  @Column(name = "user_id")
  private Long userId;
  @Column(name = "movie_id")
  private Long movieId;
}
