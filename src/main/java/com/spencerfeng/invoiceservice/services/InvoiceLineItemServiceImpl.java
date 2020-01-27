package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;
import com.spencerfeng.invoiceservice.repositories.InvoiceLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceLineItemServiceImpl implements InvoiceLineItemService {
    @Autowired
    private InvoiceLineItemRepository invoiceLineItemRepository;

    @Override
    public InvoiceLineItem save(InvoiceLineItem item) {
        return invoiceLineItemRepository.save(item);
    }

    @Override
    public void deleteById(String id) {
        invoiceLineItemRepository.deleteById(id);
    }
}
