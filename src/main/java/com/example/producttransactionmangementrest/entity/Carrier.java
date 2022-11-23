package com.example.producttransactionmangementrest.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carriers")
@Data
@NoArgsConstructor
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @JoinTable(inverseJoinColumns = @JoinColumn(name = "region_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Region> regions;

    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    void createdAt(){
        this.updatedAt=new Date();
        this.createdAt=new Date();
    }
    @PreUpdate
    void updatedAt(){this.updatedAt=new Date();}


}
