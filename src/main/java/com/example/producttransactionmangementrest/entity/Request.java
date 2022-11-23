package com.example.producttransactionmangementrest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String requestId;

    @ManyToOne
    private Place place;


    private String productId;

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
