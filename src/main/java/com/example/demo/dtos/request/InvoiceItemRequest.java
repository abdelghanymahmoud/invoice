package com.example.demo.dtos.request;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemRequest implements Serializable {

  private static final long serialVersionUID = -8788526199726880277L;

  @NotBlank(message = "Item name is required and cannot be null or blank")
  private String itemName;
  @NotNull(message = "Item price is required and cannot be null")
  @Min(value = 0, message = "Item price cannot be less than 0")
  private Double itemPrice;
  @NotNull(message = "Item quantity is required and cannot be null")
  @Min(value = 1, message = "Item quantity cannot be less than 0")
  private Integer quantity;
}
