package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.entity.Place;
import com.example.producttransactionmangementrest.repository.PlaceRepository;
import com.example.producttransactionmangementrest.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }
}
