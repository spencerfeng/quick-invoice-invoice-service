package com.spencerfeng.invoiceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class InvoiceLineItem {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name="invoice_id", nullable = false)
    @JsonIgnoreProperties("items")
    private Invoice invoice;

    private String details;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceLineItemType type;

    @Column(nullable = false)
    private float quantity = 1f;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private InvoiceItemUnitType unitType = InvoiceItemUnitType.NONE;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
