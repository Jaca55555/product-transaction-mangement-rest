package com.example.producttransactionmangementrest.repository;

import com.example.producttransactionmangementrest.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    List<Carrier> findAllByRegions_name(String regionName);
    List<Carrier> findAllByRegions(String regionName);


    Optional<Carrier> findByName(String  name);
}
