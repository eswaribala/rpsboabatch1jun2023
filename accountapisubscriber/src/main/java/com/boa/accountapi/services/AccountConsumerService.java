package com.boa.accountapi.services;

import com.boa.accountapi.dtos.Transaction;
import com.boa.accountapi.facades.AccountFacade;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumerService {


    @StreamListener(target = AccountFacade.inChannel)
    public void handlePayment(@Payload Transaction transaction) {

        System.out.println("Received Account details: "+transaction);

    }

}
