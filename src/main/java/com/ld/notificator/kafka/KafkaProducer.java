package com.ld.notificator.kafka;

import com.ld.notificator.dto.EventToApproveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, EventToApproveDTO> kafkaTemplate;

    public void sendMessage(EventToApproveDTO event) {
        log.info("Message sent: " + event.getId());
        kafkaTemplate.send("notificator-approve", event);
    }

}
