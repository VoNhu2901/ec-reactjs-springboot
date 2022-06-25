package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Rating")
@Data
@Table(name = "rating")
public class Rating {
    @EmbeddedId
    private RatingId id;

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
    @MapsId("accountId")
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "rating_account_id_fk"))
    private Account account;
}