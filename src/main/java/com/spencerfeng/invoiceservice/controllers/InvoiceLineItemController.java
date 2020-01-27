package com.spencerfeng.invoiceservice.controllers;

import com.spencerfeng.invoiceservice.services.InvoiceLineItemService;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/invoices/{invoice}/items")
public class InvoiceLineItemController {

    @Autowired
    private InvoiceLineItemService invoiceLineItemService;

    @Autowired
    private InvoiceService invoiceService;

    @DeleteMapping("/{invoiceLineItem}")
    public ResponseEntity<Void> deleteInvoiceLineItem(@PathVariable("invoiceLineItem") String id) {
        invoiceLineItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
