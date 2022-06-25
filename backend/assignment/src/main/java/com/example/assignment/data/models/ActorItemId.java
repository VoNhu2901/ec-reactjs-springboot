package com.example.assignment.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class ActorItemId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "actor_id")
    private Long actorId;

}