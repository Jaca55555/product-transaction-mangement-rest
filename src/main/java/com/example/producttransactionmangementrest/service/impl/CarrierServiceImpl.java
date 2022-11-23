package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.dto.CarrierReqDto;
import com.example.producttransactionmangementrest.dto.CarrierResDto;
import com.example.producttransactionmangementrest.dto.RegionResDto;
import com.example.producttransactionmangementrest.entity.Carrier;
import com.example.producttransactionmangementrest.entity.Region;
import com.example.producttransactionmangementrest.repository.CarrierRepository;
import com.example.producttransactionmangementrest.repository.RegionRepository;
import com.example.producttransactionmangementrest.service.CarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CarrierServiceImpl implements CarrierService {

    private final RegionRepository regionRepository;
    private final CarrierRepository carrierRepository;

    @Override
    public List<RegionResDto> saveCarrierWithRegions(CarrierReqDto carrierDto) {


        List<Region> regions = regionRepository.findAllByNameIn(carrierDto.getRegions());
        Carrier carrier = new Carrier();
        carrier.setName(carrierDto.getName());
        carrier.setRegions(regions);
        carrierRepository.save(carrier);


        return regions.stream().map(region -> new RegionResDto(region.getId(), region.getName())).sorted((Comparator.comparing(RegionResDto::getName))).collect(Collectors.toList());
    }

    @Override
    public List<CarrierResDto> getCarriersForRegion(String regionName) {
        List<Carrier> carriers = carrierRepository.findAllByRegions_name(regionName);
        return carriers.stream().map(carrier -> new CarrierResDto(carrier.getId(), carrier.getName()))
                .sorted(Comparator.comparing(CarrierResDto::getName)).collect(Collectors.toList());
    }
}
