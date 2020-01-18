package com.spencerfeng.invoiceservice.dtos;

import com.spencerfeng.invoiceservice.models.InvoiceItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemCreationDto {
    private String description;

    @Enumerated(EnumType.STRING)
    private InvoiceItemType type;
}
