package com.example.producttransactionmangementrest.repository;

import com.example.producttransactionmangementrest.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAllByNameIn(List<String> names);


}
