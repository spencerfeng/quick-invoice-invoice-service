package com.spencerfeng.invoiceservice.config;

import com.spencerfeng.invoiceservice.services.InvoiceService;
import com.spencerfeng.invoiceservice.services.InvoiceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public InvoiceService invoiceService() {
        return new InvoiceServiceImpl();
    }
}
