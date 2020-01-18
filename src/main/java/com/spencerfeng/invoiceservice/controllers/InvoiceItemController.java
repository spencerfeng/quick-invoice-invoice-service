package com.spencerfeng.invoiceservice.controllers;

import com.spencerfeng.invoiceservice.dtos.InvoiceItemCreationDto;
import com.spencerfeng.invoiceservice.exceptions.NotFoundException;
import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.models.InvoiceItem;
import com.spencerfeng.invoiceservice.services.InvoiceItemService;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/invoices/{invoice}/items")
public class InvoiceItemController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvoiceItemService invoiceItemService;

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceItem> addInvoiceItem(@PathVariable("invoice") String invoiceId, @RequestBody InvoiceItemCreationDto invoiceItemCreationDto) throws NotFoundException {

        Optional<Invoice> invoiceOptional = invoiceService.findInvoiceById(invoiceId);

        if (!invoiceOptional.isPresent()) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceItem invoiceItem = modelMapper.map(invoiceItemCreationDto, InvoiceItem.class);
        invoiceItem.setInvoice(invoiceOptional.get());

        InvoiceItem savedInvoiceItem = invoiceItemService.addInvoiceItem(invoiceItem);

        return new ResponseEntity<>(savedInvoiceItem, HttpStatus.CREATED);
    }
}
