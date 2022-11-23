package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.dto.RequestReqDto;
import com.example.producttransactionmangementrest.entity.Place;
import com.example.producttransactionmangementrest.entity.Request;
import com.example.producttransactionmangementrest.exceptions.ApiException;
import com.example.producttransactionmangementrest.repository.PlaceRepository;
import com.example.producttransactionmangementrest.repository.RequestRepository;
import com.example.producttransactionmangementrest.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RequestServiceImpl implements RequestService {

    private final PlaceRepository placeRepository;
    private final RequestRepository requestRepository;

    @Override
    public Request addRequest(RequestReqDto reqDto) {

        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());

        if (optional.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND,1001,"Place not found with name " + reqDto.getPlaceName());
        if (requestRepository.existsByRequestId(reqDto.getRequestId()))throw new  ApiException(HttpStatus.BAD_REQUEST,1002,"Request already exists ");

        Request request = Request.builder().requestId(reqDto.getRequestId()).productId(reqDto.getProductId()).place(optional.get()).build();
        return requestRepository.save(request);
    }
}
