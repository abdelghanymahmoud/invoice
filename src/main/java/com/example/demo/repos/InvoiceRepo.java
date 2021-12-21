package com.example.demo.repos;

import com.example.demo.models.Invoice;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice, Serializable> {

}
