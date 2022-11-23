package com.example.producttransactionmangementrest.dto;

import lombok.Data;


@Data
public class TransactionReqDto {
    private String transactionId;
    private String carrierName;
    private String requestId;
    private String offerId;
}
