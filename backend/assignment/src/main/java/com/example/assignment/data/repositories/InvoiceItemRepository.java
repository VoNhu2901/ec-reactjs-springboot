package com.example.assignment.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.data.entities.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

  
}
