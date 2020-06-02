package com.microservices.currencyconversionservice.Exchange;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannels {

    @Output(value = "consumer")
    MessageChannel consumer();

}
