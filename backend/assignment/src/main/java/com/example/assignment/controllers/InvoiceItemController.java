package com.example.assignment.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.assignment.data.entities.InvoiceItem;
import com.example.assignment.dto.request.InvoiceItemUpdateDTO;
import com.example.assignment.dto.response.InvoiceItemResponseDTO;
import com.example.assignment.services.InvoiceItemService;

@RestController
@RequestMapping("/api/v1/invoiceitem")
public class InvoiceItemController {
  private final InvoiceItemService invoiceItemService;

  public InvoiceItemController(InvoiceItemService invoiceItemService) {
    this.invoiceItemService = invoiceItemService;
  }

  @GetMapping
  List<InvoiceItem> getInvoiceItems() {
    return this.invoiceItemService.getAllInvoiceItems();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  InvoiceItemResponseDTO getInvoiceItemById(@PathVariable("id") Long id) {
    return this.invoiceItemService.getInvoiceItemById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  InvoiceItemResponseDTO createInvoiceItem(@RequestBody InvoiceItemUpdateDTO dto) {
    return this.invoiceItemService.createInvoiceItem(dto);
  }

  


}
