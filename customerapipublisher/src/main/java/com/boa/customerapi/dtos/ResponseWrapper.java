package com.boa.customerapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseWrapper<T> {
    private String message;
    private T payload;

    public ResponseWrapper(T payload ){
        super();
        this.payload=payload;

    }

    public ResponseWrapper(String message ){
        super();
       this.message=message;

    }

}
