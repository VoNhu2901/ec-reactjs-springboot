package com.example.assignment.models;

import javax.persistence.*;

import lombok.*;

@Entity(name = "InvoiceItem")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "invoice_item")
public class InvoiceItem {
  @EmbeddedId
  private InvoiceItemId id;

  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "invoice_item_movie_id_fk"))
  private Movie movie;

  @ManyToOne
  @MapsId("invoiceId")
  @JoinColumn(name = "invoice_id", foreignKey = @ForeignKey(name = "invoice_item_invoice_id_fk"))
  private Invoice invoice;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

}