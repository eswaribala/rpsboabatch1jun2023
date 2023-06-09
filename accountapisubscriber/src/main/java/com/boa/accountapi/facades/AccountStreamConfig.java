package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(AccountFacade.class)
public class AccountStreamConfig {
}
