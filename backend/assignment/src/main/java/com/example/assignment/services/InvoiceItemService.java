package com.example.assignment.services;

import java.util.List;

import com.example.assignment.data.entities.InvoiceItem;
import com.example.assignment.dto.request.InvoiceItemUpdateDTO;
import com.example.assignment.dto.response.InvoiceItemResponseDTO;

public interface InvoiceItemService {

  List<InvoiceItem> getAllInvoiceItems();

  InvoiceItemResponseDTO getInvoiceItemById(Long id);

  InvoiceItemResponseDTO createInvoiceItem(InvoiceItemUpdateDTO dto);
  
}
