package com.example.assignment.data.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class RatingId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "account_id")
    private Long accountId;
    
    @Column(name = "movie_id")
    private Long movieId;
}