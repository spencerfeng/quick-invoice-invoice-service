package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
