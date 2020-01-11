package com.spencerfeng.invoiceservice.dtos;

import com.spencerfeng.invoiceservice.models.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreationDto {
    private String business;

    private String client;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    private String additionalInfo;
}
