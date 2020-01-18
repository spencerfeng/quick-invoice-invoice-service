package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.Invoice;

import java.util.Optional;

public interface InvoiceService {
   Invoice addInvoice(Invoice invoice);

   Optional<Invoice> findInvoiceById(String id);
}
