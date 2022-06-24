package com.example.assignment.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.data.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


  
}
