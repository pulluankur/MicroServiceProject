package com.microservices.currencyexchangeservice.binder;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(ConsumerChannels.class)
public class BinderConsumer {

//    @StreamListener(Sink.INPUT)
//    public void process(Message<?> message) {
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
//    }

    @StreamListener("consumer")
    public void handle1(String name, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        @Header(AmqpHeaders.CONSUMER_QUEUE) String queue
        System.out.println("Received consumer name: " + name + " from: " + partition);
    }

    @StreamListener("personConsumer")
    public void personListener(@Payload Person person, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {

        System.out.println("Received person details: " + person + " from: " + partition);
    }

}