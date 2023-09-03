package com.ld.eventplanner.kafka;

import com.ld.eventplanner.dto.EventToApproveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Value("${spring.kafka.producer.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, EventToApproveDTO> kafkaTemplate;

    public void sendMessage(EventToApproveDTO event) {
        log.info("Message sent: " + event.getId());
        kafkaTemplate.send(topicName, event);
    }

}
