package com.example.producttransactionmangementrest.repository;

import com.example.producttransactionmangementrest.entity.Offer;
import com.example.producttransactionmangementrest.entity.Request;
import com.example.producttransactionmangementrest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByOffer(Offer offer);
    Optional<Transaction> findByRequest(Request request);
}
