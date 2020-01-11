package com.spencerfeng.invoiceservice.repositories;

import com.spencerfeng.invoiceservice.models.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
