package com.spencerfeng.invoiceservice.repositories;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceLineItemRepository extends CrudRepository<InvoiceLineItem, String> {
}
