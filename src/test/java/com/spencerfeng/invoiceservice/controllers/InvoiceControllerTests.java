package com.spencerfeng.invoiceservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;

    @Test
    public void addInvoice_test() throws Exception {
        Invoice invoice = new Invoice();

        when(invoiceService.addInvoice(invoice)).thenReturn(invoice);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/invoices")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
