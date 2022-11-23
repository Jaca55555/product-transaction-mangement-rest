package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.dto.RegionReqDto;
import com.example.producttransactionmangementrest.dto.PlaceResDto;
import com.example.producttransactionmangementrest.entity.Place;
import com.example.producttransactionmangementrest.entity.Region;
import com.example.producttransactionmangementrest.repository.PlaceRepository;
import com.example.producttransactionmangementrest.repository.RegionRepository;
import com.example.producttransactionmangementrest.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final PlaceRepository placeRepository;

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<PlaceResDto> saveRegionWithPlaces(RegionReqDto regionDto) {
        Region region = new Region(regionDto.getName());
        region = regionRepository.save(region);
        final Long regionId = region.getId();
        regionDto.getPlaces().forEach(placeName -> {

            if (!placeRepository.existsByName(placeName)) {
                placeRepository.save(new Place(placeName, regionId));
            }
        });

        List<Place> places = placeRepository.findAllByRegionId(regionId);

        return places.stream().sorted(Comparator.comparing(Place::getName)).map(place -> new PlaceResDto(place.getId(), place.getName()))
                .collect(Collectors.toList());

    }
}
