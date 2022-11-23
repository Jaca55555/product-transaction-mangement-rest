package com.example.producttransactionmangementrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarrierReqDto {
    private String name;
    private List<String> regions;
}
