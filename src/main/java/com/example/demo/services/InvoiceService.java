package com.example.demo.services;

import com.example.demo.dtos.request.InvoiceRequest;
import com.example.demo.dtos.response.InvoiceListResponse;
import com.example.demo.dtos.response.InvoiceResponse;
import com.example.demo.models.Invoice;
import com.example.demo.models.InvoiceItem;
import com.example.demo.repos.InvoiceItemRepo;
import com.example.demo.repos.InvoiceRepo;
import com.example.demo.utilities.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

  private final InvoiceRepo invoiceRepo;
  private final InvoiceItemRepo invoiceItemRepo;

  @Autowired
  public InvoiceService(InvoiceRepo invoiceRepo, InvoiceItemRepo invoiceItemRepo) {
    this.invoiceRepo = invoiceRepo;
    this.invoiceItemRepo = invoiceItemRepo;
  }

  @Transactional
  public InvoiceResponse addInvoice(InvoiceRequest request) {

    List<InvoiceItem> items = (List<InvoiceItem>) invoiceItemRepo.saveAll(
        InvoiceItem.get(request.getItems()));

    double totalRequestPrice = request.getTotalPrice();

    Invoice invoice = new Invoice(null, items, totalRequestPrice,
        Constants.TAX * totalRequestPrice);

    invoiceRepo.save(invoice);

    return InvoiceResponse.get(invoice);
  }

  public InvoiceListResponse getInvoices() {
    return new InvoiceListResponse(InvoiceResponse.get((List<Invoice>) invoiceRepo.findAll()));
  }
}
