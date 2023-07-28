package com.ld.notificator.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "notificator",
            groupId = "notificator-listener")
    public void consume(String message) {
        log.info("Message received: " + message);
    }
}
