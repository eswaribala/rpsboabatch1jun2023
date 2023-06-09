package com.boa.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private long transactionId;

    private Integer amount;

    private String timeStamp;

    private String sender;

    private String receiver;

    private long accountNo;
}
