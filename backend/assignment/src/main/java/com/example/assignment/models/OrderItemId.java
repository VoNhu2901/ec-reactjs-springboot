package com.example.assignment.models;

import java.io.Serializable;


import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItemId implements Serializable{
  private static final long serialVersionUID = 1L;

  @Column(name = "order_id")
  private Long orderId;
  @Column(name = "movie_id")
  private Long movieId;
}
