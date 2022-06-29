package com.example.assignment.services;

import java.util.List;

import com.example.assignment.data.entities.Invoice;
import com.example.assignment.dto.request.InvoiceUpdateDTO;
import com.example.assignment.dto.response.InvoiceResponseDTO;

public interface InvoiceService {

  List<Invoice> getAllInvoices();

  InvoiceResponseDTO getInvoiceById(Long id);

  InvoiceResponseDTO createInvoice(InvoiceUpdateDTO dto);

  InvoiceResponseDTO updateInvoice(Long id, InvoiceUpdateDTO dto);

  InvoiceResponseDTO deleteInvoice(Long id);

}
