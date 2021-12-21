package com.example.demo.dtos.response;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseData implements Serializable {

  private static final long serialVersionUID = 7244312896287446956L;

  private List<InvoiceItemResponse> invoiceItems;

  private Double total;
  private Double tax;
  private Double totalWithTax;
}
