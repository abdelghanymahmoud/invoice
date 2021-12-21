package com.example.demo.dtos.response;

import com.example.demo.models.Invoice;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse implements Serializable {

  private static final long serialVersionUID = -842865860937766982L;

  private UUID id;
  private InvoiceResponseData data;

  public static InvoiceResponse get(Invoice invoice) {
    return new InvoiceResponse(invoice.getId(),
        new InvoiceResponseData(InvoiceItemResponse.get(invoice.getItems()), invoice.getTotal(),
            invoice.getTax(), invoice.getTotal() + invoice.getTax()));
  }

  public static List<InvoiceResponse> get(List<Invoice> invoiceList) {
    List<InvoiceResponse> responses = new ArrayList<>();
    for (Invoice invoice : invoiceList) {
      responses.add(InvoiceResponse.get(invoice));
    }
    return responses;
  }

}
