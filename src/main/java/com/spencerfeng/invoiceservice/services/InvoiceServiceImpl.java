package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> findById(String id) {
        return invoiceRepository.findById(id);
    }
}
