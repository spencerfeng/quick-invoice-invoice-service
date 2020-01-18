package com.spencerfeng.invoiceservice.config;

import com.spencerfeng.invoiceservice.services.InvoiceItemService;
import com.spencerfeng.invoiceservice.services.InvoiceItemServiceImpl;
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
    public InvoiceItemService invoiceItemService() {
        return new InvoiceItemServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
