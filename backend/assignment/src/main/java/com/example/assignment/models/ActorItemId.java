package com.example.assignment.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ActorItemId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "movie_id")
  private Long movieId;

  @Column(name = "actor_id")
  private Long actorId;

}