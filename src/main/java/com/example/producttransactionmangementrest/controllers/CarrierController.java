package com.example.producttransactionmangementrest.controllers;

import com.example.producttransactionmangementrest.dto.CarrierReqDto;
import com.example.producttransactionmangementrest.dto.CarrierResDto;
import com.example.producttransactionmangementrest.dto.RegionResDto;
import com.example.producttransactionmangementrest.service.CarrierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carriers")
@RequiredArgsConstructor
@Slf4j
public class CarrierController {
    private final CarrierService carrierService;


    @PostMapping
    public List<RegionResDto> save(@RequestBody CarrierReqDto carrierDto) {
        log.info("addCarrier request: {}", carrierDto);
        return carrierService.saveCarrierWithRegions(carrierDto);

    }


    @GetMapping("/{regionName}")
    public List<CarrierResDto> getCarriersForRegion(@PathVariable String regionName) {
        log.info("getCarriersForRegion request: {}", regionName);
        return carrierService.getCarriersForRegion(regionName);

    }


}
