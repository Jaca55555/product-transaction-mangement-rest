package com.example.producttransactionmangementrest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String
            transactionId;

    @ManyToOne
    private Carrier carrier;

    @OneToOne
    private Request request;
    @OneToOne
    private Offer offer;

    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    void createdAt() {
        this.updatedAt = new Date();
        this.createdAt = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = new Date();
    }


}
