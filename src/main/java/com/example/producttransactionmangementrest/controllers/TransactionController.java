package com.example.producttransactionmangementrest.controllers;

import com.example.producttransactionmangementrest.dto.OfferReqDto;
import com.example.producttransactionmangementrest.dto.TransactionReqDto;
import com.example.producttransactionmangementrest.exceptions.ApiException;
import com.example.producttransactionmangementrest.exceptions.ErrorResponse;
import com.example.producttransactionmangementrest.service.OfferService;
import com.example.producttransactionmangementrest.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;


    @PostMapping
    public ResponseEntity addTransaction(@RequestBody TransactionReqDto reqDto) {
        log.info("addTransaction request: {}", reqDto);
        try {
            return ResponseEntity.ok(transactionService.addTransaction(reqDto));
        } catch (ApiException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getCode(), e.getMessage()), e.getHttpStatus());
        }

    }

}
