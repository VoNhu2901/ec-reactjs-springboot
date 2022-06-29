package com.example.assignment.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.data.entities.Invoice;
import com.example.assignment.data.repositories.InvoiceRepository;
import com.example.assignment.dto.request.InvoiceUpdateDTO;
import com.example.assignment.dto.response.InvoiceResponseDTO;
import com.example.assignment.exceptions.ResourceFoundException;
import com.example.assignment.services.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  private final InvoiceRepository invoiceRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ModelMapper modelMapper) {
    this.invoiceRepository = invoiceRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<Invoice> getAllInvoices() {
    return this.invoiceRepository.findAll();
  }

  @Override
  public InvoiceResponseDTO getInvoiceById(Long id) {
    return modelMapper.map(
        this.invoiceRepository.findById(id).orElseThrow(() -> new ResourceFoundException("Invoice Not Found")),
        InvoiceResponseDTO.class);
  }
  
  @Override
  public InvoiceResponseDTO createInvoice(InvoiceUpdateDTO dto) {
    Invoice invoice = modelMapper.map(dto, Invoice.class);
    Invoice saveInvoice = invoiceRepository.save(invoice);
    return modelMapper.map(saveInvoice, InvoiceResponseDTO.class);
  }

  @Override
  public InvoiceResponseDTO updateInvoice(Long id, InvoiceUpdateDTO dto) {
    Invoice invoice = modelMapper.map(dto, Invoice.class);
    invoice.setId(id);
    Invoice saveInvoice = invoiceRepository.save(invoice);
    return modelMapper.map(saveInvoice, InvoiceResponseDTO.class);
  }

  @Override
  public InvoiceResponseDTO deleteInvoice(Long id) {
    Invoice invoice = this.invoiceRepository.findById(id)
        .orElseThrow(() -> new ResourceFoundException("Invoice Not Found"));

    this.invoiceRepository.delete(invoice);
    return modelMapper.map(invoice, InvoiceResponseDTO.class);
  }
}
