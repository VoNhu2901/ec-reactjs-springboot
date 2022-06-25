package com.example.assignment.data.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InvoiceItemId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "invoice_id")
    private Long invoiceId;
    @Column(name = "movie_id")
    private Long movieId;
}