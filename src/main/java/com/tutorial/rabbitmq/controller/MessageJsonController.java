package com.tutorial.rabbitmq.controller;

import com.tutorial.rabbitmq.dto.User;
import com.tutorial.rabbitmq.publisher.RabbitMQJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/json")
public class MessageJsonController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageJsonController.class);

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    private ResponseEntity<String> sendMessageJson(@RequestBody User user){
        LOGGER.info("Starting send json....");
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Success send msg");
    }
}
