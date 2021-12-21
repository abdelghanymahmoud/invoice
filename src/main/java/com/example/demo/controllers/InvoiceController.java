package com.example.demo.controllers;

import com.example.demo.dtos.request.InvoiceRequest;
import com.example.demo.services.InvoiceService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

  private final InvoiceService invoiceService;

  @Autowired
  public InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  @PostMapping
  public ResponseEntity<?> add(@Valid @RequestBody InvoiceRequest request) {
    return new ResponseEntity<>(invoiceService.addInvoice(request), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> get() {
    return ResponseEntity.ok(invoiceService.getInvoices());
  }
}
