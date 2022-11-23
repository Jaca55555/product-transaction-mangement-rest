package com.example.producttransactionmangementrest.controllers;

import com.example.producttransactionmangementrest.dto.RequestReqDto;
import com.example.producttransactionmangementrest.exceptions.ErrorResponse;
import com.example.producttransactionmangementrest.exceptions.ApiException;
import com.example.producttransactionmangementrest.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
@Slf4j
public class RequestController {
    private final RequestService requestService;


    @PostMapping
    public ResponseEntity addRequest(@RequestBody RequestReqDto reqDto) {
        log.info("addRequest request: {}", reqDto);
        try {
            return ResponseEntity.ok(requestService.addRequest(reqDto));
        } catch (ApiException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getCode(), e.getMessage()), e.getHttpStatus());
        }


    }


}
