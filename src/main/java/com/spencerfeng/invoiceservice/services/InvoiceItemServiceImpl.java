package com.spencerfeng.invoiceservice.services;

import com.spencerfeng.invoiceservice.models.InvoiceLineItem;
import com.spencerfeng.invoiceservice.repositories.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceItemServiceImpl implements InvoiceItemService {
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceLineItem addInvoiceItem(InvoiceLineItem invoiceItem) {
        return invoiceItemRepository.save(invoiceItem);
    }
}
