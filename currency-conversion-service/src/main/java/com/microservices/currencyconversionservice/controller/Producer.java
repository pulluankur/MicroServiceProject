package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.Exchange.ProducerChannels;
import com.microservices.currencyconversionservice.dto.Person;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/send")
@RestController
@EnableBinding(ProducerChannels.class)
public class Producer {

    private final MessageChannel channel;
    private final MessageChannel personChannel;

    public Producer(ProducerChannels channel, ProducerChannels personChannel) {
        this.channel = channel.producer();
        this.personChannel = personChannel.personProducer();
    }

    @PostMapping("/{name}")
    public String publish(@PathVariable String name) {
        String greet = "Hello " + name + "!";
        Message<String> build = MessageBuilder.withPayload(greet).setHeader("partitionKey", greet).build();
        this.channel.send(build);
        return "Successfully sent: " + name;
    }

    @PostMapping(value = "/person")
    public Person publishPerson(@RequestBody Person person) {
        Message<Person> build = MessageBuilder.withPayload(person).setHeader("partitionKey",person).build();
        this.personChannel.send(build);
        return person;
    }

}

