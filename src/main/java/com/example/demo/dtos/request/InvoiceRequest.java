package com.example.demo.dtos.request;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest implements Serializable {

  private static final long serialVersionUID = -2736575481253015273L;

  @NotNull(message = "Invoice items is required and cannot be null")
  @NotEmpty(message = "Invoice items is required and cannot be empty")
  @Valid
  private List<InvoiceItemRequest> items;

  public double getTotalPrice() {
    double total = 0;
    for (InvoiceItemRequest item : items) {
      total += item.getItemPrice() * item.getQuantity();
    }
    return total;
  }
}
