package com.example.producttransactionmangementrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class RegionReqDto {
    private String name;
    private List<String> places;
}
