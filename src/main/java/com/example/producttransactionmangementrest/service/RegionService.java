package com.example.producttransactionmangementrest.service;


import com.example.producttransactionmangementrest.dto.RegionReqDto;
import com.example.producttransactionmangementrest.dto.PlaceResDto;
import com.example.producttransactionmangementrest.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findAll();

    Region save(Region region);

    List<PlaceResDto>  saveRegionWithPlaces(RegionReqDto regionDto);
}
