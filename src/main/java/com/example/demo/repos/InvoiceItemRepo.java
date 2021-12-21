package com.example.demo.repos;

import com.example.demo.models.InvoiceItem;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepo extends CrudRepository<InvoiceItem, Serializable> {
}
