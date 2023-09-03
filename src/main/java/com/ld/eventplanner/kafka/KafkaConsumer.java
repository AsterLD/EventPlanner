package com.ld.eventplanner.kafka;

import com.ld.eventplanner.dto.EventStatusDTO;
import com.ld.eventplanner.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    @Autowired
    private final EventService eventService;

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EventStatusDTO eventStatusDTO) {
        log.info("Message get: " + eventStatusDTO.getEventStatus());
        eventService.changeEventStatus(eventStatusDTO.getEventStatus(), eventStatusDTO.getId());
    }
}
