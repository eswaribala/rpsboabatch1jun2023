package com.boa.customerapi.services;

//import com.boa.customerapi.facades.CustomerFacade;
import com.boa.customerapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
/*
@Service
public class TransactionService {

    @Autowired
    private CustomerFacade customerFacade;


    public boolean publishTransaction(Transaction transaction){

        MessageChannel msgChannel= customerFacade.outChannel();
        if(transaction.getAccountNo()>0) {
            return  msgChannel.send(MessageBuilder
                    .withPayload(transaction)
                    .setHeader(MessageHeaders.CONTENT_TYPE,
                            MimeTypeUtils.APPLICATION_JSON)
                    .build());
        }
        else
        {
            return false;
        }

    }

}
*/