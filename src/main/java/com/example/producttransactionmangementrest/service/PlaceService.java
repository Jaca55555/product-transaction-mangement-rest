package com.example.producttransactionmangementrest.service;

import com.example.producttransactionmangementrest.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();

    Place save(Place place);
}
