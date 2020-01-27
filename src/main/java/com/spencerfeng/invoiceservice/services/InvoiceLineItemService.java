package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;

public interface InvoiceLineItemService {
    InvoiceLineItem save(InvoiceLineItem item);
    void deleteById(String id);
}
