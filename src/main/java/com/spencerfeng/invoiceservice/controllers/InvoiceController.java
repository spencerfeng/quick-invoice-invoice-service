package com.spencerfeng.invoiceservice.controllers;

import com.spencerfeng.invoiceservice.dtos.InvoiceCreationDto;
import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.repositories.InvoiceRepository;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceCreationDto invoiceDto) {
        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);

        Invoice savedInvoice = invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }
}
