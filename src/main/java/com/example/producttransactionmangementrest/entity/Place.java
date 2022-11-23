package com.example.producttransactionmangementrest.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id",insertable = false,updatable = false)
    private Region region;
    @Column(name = "region_id")
    private Long regionId;
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    void createdAt(){
        this.updatedAt=new Date();
        this.createdAt=new Date();
    }
    @PreUpdate
    void updatedAt(){this.updatedAt=new Date();}

    public Place(String name, Long regionId) {
        this.name = name;
        this.regionId = regionId;
    }
}
