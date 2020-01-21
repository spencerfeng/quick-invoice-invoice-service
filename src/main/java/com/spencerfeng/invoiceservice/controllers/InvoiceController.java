package com.spencerfeng.invoiceservice.controllers;

import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice() {
        Invoice invoice = new Invoice();
        Invoice savedInvoice = invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }
}
