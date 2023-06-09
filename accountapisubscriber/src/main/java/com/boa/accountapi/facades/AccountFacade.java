package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface AccountFacade {

    String inChannel="customers-in";

    @Input(inChannel)
    MessageChannel mnessageInChannel();
}
