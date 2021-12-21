package com.example.demo.dtos.response;

import com.example.demo.models.InvoiceItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemResponse implements Serializable {

  private static final long serialVersionUID = -5400588553565356021L;

  private String itemName;
  private Double itemPrice;
  private Integer quantity;

  public static InvoiceItemResponse get(InvoiceItem invoiceItem) {
    return new InvoiceItemResponse(invoiceItem.getItemName(), invoiceItem.getItemPrice(),
        invoiceItem.getQuantity());
  }

  public static List<InvoiceItemResponse> get(List<InvoiceItem> invoiceItems) {
    List<InvoiceItemResponse> responses = new ArrayList<>();
    for (InvoiceItem invoiceItem : invoiceItems) {
      responses.add(InvoiceItemResponse.get(invoiceItem));
    }
    return responses;
  }
}
