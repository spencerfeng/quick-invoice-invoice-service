package com.spencerfeng.invoiceservice.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Invoice implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String business;

    private String client;

    private String invoiceNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvoiceStatus status = InvoiceStatus.DRAFT;

    private String additionalInfo;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceLineItem> items = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void addLineItem(InvoiceLineItem item) {
        items.add(item);
        item.setInvoice(this);
    }

    public void removeLineItem(InvoiceLineItem item) {
        items.remove(item);
        item.setInvoice(null);
    }

    public void removeAllLineItems() {
        items.forEach(item -> {
            item.setInvoice(null);
        });
        items.clear();
    }
}
