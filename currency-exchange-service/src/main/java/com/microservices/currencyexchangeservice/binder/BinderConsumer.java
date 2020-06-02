package com.microservices.currencyexchangeservice.binder;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.core.KafkaTemplate;

@EnableBinding({Sink.class, ConsumerChannels.class})
public class BinderConsumer {

//    @StreamListener(Sink.INPUT)
//    public void process(Message<?> message) {
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
//    }

    @StreamListener(Sink.INPUT)
    public void handle(String name) {

        System.out.println("Received sink name: " + name);
    }

    @StreamListener("consumer")
    public void handle1(String name) {

        System.out.println("Received consumer name: " + name);
    }
}