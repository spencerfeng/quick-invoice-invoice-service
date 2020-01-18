package com.spencerfeng.invoiceservice.repositories;

import com.spencerfeng.invoiceservice.models.InvoiceItem;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long> {
}
