package com.spencerfeng.invoiceservice.repositories;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceItemRepository extends CrudRepository<InvoiceLineItem, Long> {
}
