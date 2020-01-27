package com.spencerfeng.invoiceservice.config;

import com.spencerfeng.invoiceservice.services.InvoiceLineItemService;
import com.spencerfeng.invoiceservice.services.InvoiceLineItemServiceImpl;
import com.spencerfeng.invoiceservice.services.InvoiceService;
import com.spencerfeng.invoiceservice.services.InvoiceServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public InvoiceService invoiceService() {
        return new InvoiceServiceImpl();
    }

    @Bean
    public InvoiceLineItemService invoiceItemService() {
        return new InvoiceLineItemServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
