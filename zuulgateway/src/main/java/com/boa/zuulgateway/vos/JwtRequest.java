package com.boa.zuulgateway.vos;

import lombok.Data;

@Data
public class JwtRequest {

    private String userName;
    private String userPwd;
}
