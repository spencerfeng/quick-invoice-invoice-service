package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;

public interface InvoiceItemService {
    InvoiceLineItem addInvoiceItem(InvoiceLineItem invoiceItem);
}
