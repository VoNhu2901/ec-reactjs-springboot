package com.example.assignment.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "Category")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {
  @Id
  @SequenceGenerator(name = "category_squence", sequenceName = "category_squence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_squence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;

  @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime createAt;

  @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = { CascadeType.PERSIST,
      CascadeType.REMOVE }, fetch = FetchType.LAZY)
  private final List<Movie> movies = new ArrayList<>();
}