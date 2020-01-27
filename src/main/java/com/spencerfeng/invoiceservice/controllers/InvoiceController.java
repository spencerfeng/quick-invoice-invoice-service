package com.spencerfeng.invoiceservice.controllers;

import com.spencerfeng.invoiceservice.exceptions.NotFoundException;
import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.models.InvoiceLineItem;
import com.spencerfeng.invoiceservice.services.InvoiceLineItemService;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceLineItemService invoiceLineItemService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice() {
        Invoice invoice = new Invoice();
        Invoice savedInvoice = invoiceService.save(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable String invoiceId, @RequestBody Invoice updatedInvoice) {
        Optional<Invoice> invoiceOptional = invoiceService.findById(invoiceId);

        if (!invoiceOptional.isPresent()) {
            throw new NotFoundException("Invoice not found");
        }

        Invoice invoice = invoiceOptional.get();

        // delete existing line items
        invoice.getItems().forEach(item -> {
            invoiceLineItemService.deleteById(item.getId());
        });
        invoice.removeAllLineItems();

        // create new line items
        updatedInvoice.getItems().forEach(item -> {
            InvoiceLineItem newItem = new InvoiceLineItem();
            newItem.setTitle(item.getTitle());
            newItem.setDetails(item.getDetails());
            newItem.setType(item.getType());
            newItem.setQuantity(item.getQuantity());
            newItem.setRate(item.getRate());
            invoice.addLineItem(newItem);
            invoiceLineItemService.save(newItem);
        });

        invoice.setBusiness(updatedInvoice.getBusiness());
        invoice.setClient(updatedInvoice.getClient());

        Invoice savedInvoice = invoiceService.save(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.OK);
    }
}
