package com.example.assignment.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.data.entities.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

  
}
