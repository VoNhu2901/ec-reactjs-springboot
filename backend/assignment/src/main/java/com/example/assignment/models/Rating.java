package com.example.assignment.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Rating")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rating")
public class Rating {
  @EmbeddedId
  private Rating id;

  @Column(name = "star_number", nullable = false)
  private Integer starNumber;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "rating_movie_id_fk"))
  private Movie movie;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "rating_user_id_fk"))
  private User user;
}
