package com.example.demo.models;

import com.example.demo.dtos.request.InvoiceItemRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "invoice_item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem implements Serializable {

  private static final long serialVersionUID = 2430178138008547154L;

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private UUID id;

  private String itemName;
  private Double itemPrice;
  private Integer quantity;

  public static InvoiceItem get(InvoiceItemRequest itemRequest) {
    return new InvoiceItem(null, itemRequest.getItemName(), itemRequest.getItemPrice(),
        itemRequest.getQuantity());
  }

  public static List<InvoiceItem> get(List<InvoiceItemRequest> itemRequests) {
    List<InvoiceItem> list = new ArrayList<>();
    for (InvoiceItemRequest itemRequest : itemRequests) {
      list.add(get(itemRequest));
    }
    return list;
  }
}
