package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.Invoice;

import java.util.Optional;

public interface InvoiceService {
   Invoice save(Invoice invoice);

   Optional<Invoice> findById(String id);
}
