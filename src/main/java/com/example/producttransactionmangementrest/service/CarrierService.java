package com.example.producttransactionmangementrest.service;

import com.example.producttransactionmangementrest.dto.CarrierReqDto;
import com.example.producttransactionmangementrest.dto.CarrierResDto;
import com.example.producttransactionmangementrest.dto.RegionResDto;

import java.util.List;

public interface CarrierService {

    List<RegionResDto>  saveCarrierWithRegions(CarrierReqDto carrierDto);

    List<CarrierResDto> getCarriersForRegion(String regionName);

}
