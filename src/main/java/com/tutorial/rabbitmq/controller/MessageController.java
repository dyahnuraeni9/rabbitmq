package com.tutorial.rabbitmq.controller;

import com.tutorial.rabbitmq.publisher.RabbitMQProduser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class MessageController {


    public MessageController(RabbitMQProduser producer) {
        this.producer = producer;
    }

    private RabbitMQProduser producer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Send Message -> "+message);
    }

}
