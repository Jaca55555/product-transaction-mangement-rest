package com.example.producttransactionmangementrest.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    void createdAt(){
        this.updatedAt=new Date();
        this.createdAt=new Date();
    }
    @PreUpdate
    void updatedAt(){this.updatedAt=new Date();}


    public Region(String name) {
        this.name = name;
    }

   public static Region creatFromName(String name){
        Region region=new Region();
        region.setName(name);
        return region;
   }

}
