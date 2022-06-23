package com.example.assignment.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
  @Id
  @SequenceGenerator(name = "user_squence", sequenceName = "user_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
  private String firstName;

  @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
  private String lastName;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE }, fetch = FetchType.LAZY)
  private final List<Order> orders = new ArrayList<>();
}
