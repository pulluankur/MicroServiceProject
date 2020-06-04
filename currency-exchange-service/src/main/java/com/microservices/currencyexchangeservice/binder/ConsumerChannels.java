package com.microservices.currencyexchangeservice.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    @Input(value = "consumer")
    SubscribableChannel consumer();

    @Input(value = "personConsumer")
    SubscribableChannel personConsumer();

}
