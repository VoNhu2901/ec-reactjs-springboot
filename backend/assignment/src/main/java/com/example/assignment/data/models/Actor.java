package com.example.assignment.data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity(name = "Actor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor {

  @Id
  @SequenceGenerator(name = "actor_squence", sequenceName = "actor_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
  private String firstName;

  @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
  private String lastName;

  @Column(name = "email", nullable = false, columnDefinition = "TEXT")
  private String email;

  @Column(name = "password", nullable = false, columnDefinition = "TEXT")
  private String password;

  @Column(name = "avatar", nullable = true, columnDefinition = "TEXT")
  private String avatar;

  @Column(name = "phone", nullable = false, columnDefinition = "TEXT")
  private String phone;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "movie", cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE })
  private final List<ActorItem> actorItems = new ArrayList<>();

}