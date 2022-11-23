package com.example.producttransactionmangementrest.service;

import com.example.producttransactionmangementrest.dto.TransactionReqDto;
import com.example.producttransactionmangementrest.entity.Transaction;


public interface TransactionService {

    Transaction addTransaction(TransactionReqDto reqDto);
}
