package com.example.assignment.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity(name = "Order")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order")
public class Order {
  @Id
  @SequenceGenerator(name = "order_squence", sequenceName = "order_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "amount", nullable = false)
  private Integer amount;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE })
  private final List<OrderItem> orderItems = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_order_fk"))
  private User user;
}
