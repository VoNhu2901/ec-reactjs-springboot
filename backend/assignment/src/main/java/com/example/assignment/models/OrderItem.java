package com.example.assignment.models;


import javax.persistence.*;

import lombok.*;

@Entity(name = "OrderItem")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {
  @EmbeddedId
  private OrderItemId id;
  
  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "order_item_movie_id_fk"))
  private Movie movie;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_item_order_id_fk"))
  private Order order;


  @Column(name = "quantity", nullable = false)
  private Integer quantity;

 
}
