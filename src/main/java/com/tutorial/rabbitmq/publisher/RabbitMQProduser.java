package com.tutorial.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProduser {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProduser.class);


    public RabbitMQProduser(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Routing Key -> %s", routingKey));
        LOGGER.info(String.format("Exchange -> %s", exchange));
        LOGGER.info(String.format("Message send -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }



}
