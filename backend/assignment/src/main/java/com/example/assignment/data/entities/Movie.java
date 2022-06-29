package com.example.assignment.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @OneToMany(mappedBy = "movie", cascade = { CascadeType.ALL })
    private final List<InvoiceItem> invoiceItems = new ArrayList<>();
    @OneToMany(mappedBy = "movie", cascade = { CascadeType.ALL })
    private final List<ActorItem> actorItems = new ArrayList<>();
    @OneToMany(mappedBy = "movie", cascade = { CascadeType.ALL })
    private final List<Rating> ratings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "category_movie_fk"))
    private Category category;
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "language_movie_fk"))
    private Language language;
    
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    @SequenceGenerator(name = "moive_squence", sequenceName = "moive_squence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moive_squence")
    
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;
    
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "release_year", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate releaseYear;
    
    @Column(name = "price", nullable = false)
    private Integer price;
    
    @Column(name = "length", nullable = false)
    private Integer length;
    
    @Column(name = "rating", nullable = false)
    private Integer rating;
    
    @Column(name = "url_image", nullable = false, columnDefinition = "TEXT")
    private String urlImage;
    
    @Column(name = "url_trailer", nullable = false, columnDefinition = "TEXT")
    private String urlTrailer;
    
    @Column(name = "amount", nullable = false)
    private Integer amount;
    
    @Column(name = "status", nullable = false)
    private Integer status;
    // @Temporal(TemporalType.DATE)
   
    @Column(name = "create_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createAt;
    
    @Column(name = "update_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updateAt;
    
}