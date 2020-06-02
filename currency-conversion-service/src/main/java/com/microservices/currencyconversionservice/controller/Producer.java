package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.Exchange.ProducerChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/send")
@EnableBinding(ProducerChannels.class)
public class Producer {

    private MessageChannel channel;

    public Producer(ProducerChannels channel) {
        this.channel = channel.consumer();
    }

    @PostMapping("/{name}")
    public void publish(@PathVariable String name) {
        String greet = "Hello " + name + "!";
        Message<String> build = MessageBuilder.withPayload(greet).build();
        this.channel.send(build);
    }

}
