package com.example.assignment.data.models;

import javax.persistence.*;

import lombok.*;

@Entity(name = "ActorItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor_item")
public class ActorItem {
  @EmbeddedId
  private ActorItemId id;

  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "actor_item_movie_id_fk"))
  private Movie movie;

  @ManyToOne
  @MapsId("actorId")
  @JoinColumn(name = "actor_id", foreignKey = @ForeignKey(name = "actor_item_actor_id_fk"))
  private Actor actor;

}