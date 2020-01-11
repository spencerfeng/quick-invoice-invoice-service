package com.spencerfeng.invoiceservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spencerfeng.invoiceservice.dtos.InvoiceCreationDto;
import com.spencerfeng.invoiceservice.models.Invoice;
import com.spencerfeng.invoiceservice.models.InvoiceStatus;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import org.modelmapper.ModelMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void addInvoice_test() throws Exception {
        InvoiceCreationDto invoiceDto = new InvoiceCreationDto(
                "Test Business",
                "Test Client",
                InvoiceStatus.SENT,
                "Additional Info"
        );

        Invoice invoice = new Invoice();
        invoice.setBusiness("Test Business");
        invoice.setClient("Test Client");
        invoice.setStatus(InvoiceStatus.SENT);
        invoice.setAdditionalInfo("Additional Info");

        when(modelMapper.map(invoiceDto, Invoice.class)).thenReturn(invoice);

        when(invoiceService.addInvoice(invoice)).thenReturn(invoice);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/invoices")
                .content(asJsonString(invoiceDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.business").value("Test Business"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.client").value("Test Client"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SENT"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.additionalInfo").value("Additional Info"));


    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
