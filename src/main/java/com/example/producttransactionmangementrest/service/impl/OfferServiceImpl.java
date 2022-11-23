package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.dto.OfferReqDto;
import com.example.producttransactionmangementrest.entity.Offer;
import com.example.producttransactionmangementrest.entity.Place;
import com.example.producttransactionmangementrest.exceptions.ApiException;
import com.example.producttransactionmangementrest.repository.OfferRepository;
import com.example.producttransactionmangementrest.repository.PlaceRepository;
import com.example.producttransactionmangementrest.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OfferServiceImpl implements OfferService {

    private final PlaceRepository placeRepository;
    private final OfferRepository offerRepository;

    @Override
    public Offer addOffer(OfferReqDto reqDto) {
        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());

        if (optional.isEmpty())
            throw new ApiException(HttpStatus.NOT_FOUND, 1001, "Place not found with name" + reqDto.getPlaceName());
        if (offerRepository.existsByOfferId(reqDto.getOfferId()))
            throw new ApiException(HttpStatus.BAD_REQUEST, 1002, "Offer already exists ");

//        Offer offer = Offer.builder().offerId(reqDto.getOfferId()).productId(reqDto.getProductId()).place(optional.get()).build();


        Offer offer = new Offer();
        offer.setOfferId(reqDto.getOfferId());
        offer.setPlace(optional.get());
        offer.setProductId(reqDto.getProductId());

        return offerRepository.save(offer);
    }

}
