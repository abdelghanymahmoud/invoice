package com.example.demo.dtos.response;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceListResponse implements Serializable {

  private static final long serialVersionUID = -9056162404214957249L;

  private List<InvoiceResponse> invoiceResponseList;

  private Integer invoiceCount;
  private Double totalInvoiceAmount;

  public InvoiceListResponse(List<InvoiceResponse> list) {
    this.invoiceResponseList = list;
    invoiceCount = list.size();
    totalInvoiceAmount = new Double(0);
    for (InvoiceResponse invoiceResponse : list) {
      totalInvoiceAmount += invoiceResponse.getData().getTotalWithTax();
    }
  }
}
