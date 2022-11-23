package com.example.producttransactionmangementrest.repository;

import com.example.producttransactionmangementrest.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RequestRepository extends JpaRepository<Request, Long> {
    boolean existsByRequestId(String requestId);
    Optional<Request> findByRequestId(String  requestId);
}
