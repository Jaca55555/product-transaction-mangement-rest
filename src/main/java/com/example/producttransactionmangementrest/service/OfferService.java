package com.example.producttransactionmangementrest.service;

import com.example.producttransactionmangementrest.dto.OfferReqDto;
import com.example.producttransactionmangementrest.entity.Offer;



public interface OfferService {


    Offer addOffer(OfferReqDto  reqDto);

}
