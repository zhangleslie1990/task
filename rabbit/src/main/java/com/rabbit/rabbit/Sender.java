package com.rabbit.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private static AmqpTemplate amqpTemplate;

    public static void send() {
        amqpTemplate.convertAndSend("hello", "welcoming rabitmq");
    }

    public static void main(String[] args) {
        send();
    }
}
