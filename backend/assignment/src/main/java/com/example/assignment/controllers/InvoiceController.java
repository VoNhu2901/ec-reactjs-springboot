package com.example.assignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.assignment.data.entities.Invoice;
import com.example.assignment.dto.request.InvoiceUpdateDTO;
import com.example.assignment.dto.response.InvoiceResponseDTO;
import com.example.assignment.services.InvoiceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {
  private final InvoiceService invoiceService;

  public InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  @GetMapping
  List<Invoice> getInvoices() {
    return this.invoiceService.getAllInvoices();
  }

  @GetMapping("/{id}")
  @ResponseStatus
  InvoiceResponseDTO getInvoiceById(@PathVariable("id") Long id) {
    return this.invoiceService.getInvoiceById(id);
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  InvoiceResponseDTO createInvoice(@RequestBody InvoiceUpdateDTO dto) {
    return this.invoiceService.createInvoice(dto);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  InvoiceResponseDTO updateInvoice(@PathVariable("id") Long id, @RequestBody InvoiceUpdateDTO dto) {
    return this.invoiceService.updateInvoice(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  InvoiceResponseDTO deleteInvoice(@PathVariable("id") Long id) {
    return this.invoiceService.deleteInvoice(id);
  }

}
