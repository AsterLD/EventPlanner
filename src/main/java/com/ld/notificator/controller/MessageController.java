package com.ld.notificator.controller;


import com.ld.notificator.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping(value = "/sent/{message}")
    public String createItem(@PathVariable("message") String message) {
        kafkaProducer.sendMessage(message);
        return message + "was sent.";
    }
}
