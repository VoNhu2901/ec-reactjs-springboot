package com.example.assignment.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class InvoiceItemId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "invoice_id")
  private Long invoiceId;
  @Column(name = "movie_id")
  private Long movieId;
}