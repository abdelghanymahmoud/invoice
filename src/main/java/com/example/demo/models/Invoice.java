package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*

Write a simple API in java that
POST /invoices : receives invoice payload, calculate tax and total and then store the data to database
Get /invoices: return list of invoices and summary(invoice_count, total_invoice_amount)
It must have a swagger doc
It must have a proper database
A little UI to input data and view calculation.

 */
@Entity
@Table(name = "invoice")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Invoice implements Serializable {

  private static final long serialVersionUID = 8175637952562374893L;

  @Id
  @GeneratedValue
  @Setter(AccessLevel.NONE)
  private UUID id;

  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "invoice_id")
  private List<InvoiceItem> items;

  private Double total;
  private Double tax;
}
