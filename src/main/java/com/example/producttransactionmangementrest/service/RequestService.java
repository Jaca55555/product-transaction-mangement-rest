package com.example.producttransactionmangementrest.service;

import com.example.producttransactionmangementrest.dto.RequestReqDto;
import com.example.producttransactionmangementrest.entity.Request;


public interface RequestService {


    Request addRequest(RequestReqDto reqDto);

}
