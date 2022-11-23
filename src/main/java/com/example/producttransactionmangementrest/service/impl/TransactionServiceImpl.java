package com.example.producttransactionmangementrest.service.impl;

import com.example.producttransactionmangementrest.dto.TransactionReqDto;
import com.example.producttransactionmangementrest.entity.Carrier;
import com.example.producttransactionmangementrest.entity.Offer;
import com.example.producttransactionmangementrest.entity.Request;
import com.example.producttransactionmangementrest.entity.Transaction;
import com.example.producttransactionmangementrest.exceptions.ApiException;
import com.example.producttransactionmangementrest.repository.*;
import com.example.producttransactionmangementrest.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TransactionServiceImpl implements TransactionService {
    private final CarrierRepository carrierRepository;
    private final OfferRepository offerRepository;
    private final RequestRepository requestRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(TransactionReqDto reqDto) {


        Optional<Carrier> optionalCarrier=carrierRepository.findByName(reqDto.getCarrierName());
        if (optionalCarrier.isEmpty())throw new ApiException(HttpStatus.NOT_FOUND,1003,"Carrier not found");

        Optional<Offer> optionalOffer=offerRepository.findByOfferId(reqDto.getOfferId());
        if (optionalOffer.isEmpty())throw new ApiException(HttpStatus.NOT_FOUND,1004,"Offer not found");

        Optional<Request> optionalRequest=requestRepository.findByRequestId(reqDto.getRequestId());
        if (optionalRequest.isEmpty())throw new ApiException(HttpStatus.NOT_FOUND,1005,"Request not found");

        Carrier carrier=optionalCarrier.get();
        Offer offer=optionalOffer.get();
        Request request=optionalRequest.get();

        Optional<Transaction>  optional=transactionRepository.findByOffer(offer);
        if (optional.isPresent()) throw  new ApiException(HttpStatus.BAD_REQUEST,1006,"Transaction already bound to offer");


          optional=transactionRepository.findByRequest(request);
        if (optional.isPresent()) throw  new ApiException(HttpStatus.BAD_REQUEST,1007,"Transaction already bound to request");

        if (!offer.getProductId().equals(request.getProductId())) throw  new ApiException(HttpStatus.BAD_REQUEST,1008,"Offer and request product ids must be same");


        if (!carrier.getRegions().contains(offer.getPlace().getRegion())||
                !carrier.getRegions().contains(request.getPlace().getRegion()))
            throw  new ApiException(HttpStatus.BAD_REQUEST,1009,"This carrier should  serve  place ");

        Transaction transaction=new Transaction();
        transaction.setTransactionId(reqDto.getTransactionId());
        transaction.setCarrier(carrier);
        transaction.setOffer(offer);
        transaction.setRequest(request);

     return    transactionRepository.save(transaction);

    }
}
