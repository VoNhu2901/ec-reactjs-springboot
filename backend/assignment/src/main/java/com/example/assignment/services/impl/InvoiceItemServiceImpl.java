package com.example.assignment.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.InvoiceItem;
import com.example.assignment.data.repositories.InvoiceItemRepository;
import com.example.assignment.dto.request.InvoiceItemUpdateDTO;
import com.example.assignment.dto.response.InvoiceItemResponseDTO;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.InvoiceItemService;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

  private final InvoiceItemRepository invoiceItemRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository, ModelMapper modelMapper) {
    this.invoiceItemRepository = invoiceItemRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<InvoiceItem> getAllInvoiceItems() {
    return this.invoiceItemRepository.findAll();
  }

  @Override
  public InvoiceItemResponseDTO getInvoiceItemById(Long id) {
    return modelMapper.map(
        this.invoiceItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("InvoiceItem Not Found")),
        InvoiceItemResponseDTO.class);
  }
  
  @Override
  public InvoiceItemResponseDTO createInvoiceItem(InvoiceItemUpdateDTO dto) {
    InvoiceItem invoiceItem = modelMapper.map(dto, InvoiceItem.class);
    InvoiceItem saveInvoiceItem = invoiceItemRepository.save(invoiceItem);
    return modelMapper.map(saveInvoiceItem, InvoiceItemResponseDTO.class);
  } 
  
  
}
