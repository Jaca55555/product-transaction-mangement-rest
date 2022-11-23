package com.example.producttransactionmangementrest.controllers;

import com.example.producttransactionmangementrest.dto.RegionReqDto;
import com.example.producttransactionmangementrest.dto.PlaceResDto;
import com.example.producttransactionmangementrest.entity.Region;
import com.example.producttransactionmangementrest.service.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
@Slf4j
public class RegionController {
    private final RegionService regionService;


    @PostMapping

    public  List<PlaceResDto> save(@RequestBody RegionReqDto regionDto ){
        log.info("addRegion request: {}", regionDto);
     return regionService.saveRegionWithPlaces(regionDto);

    }

    @GetMapping
    public List<Region> getAll(){

       return regionService.findAll();

    }

}
