package com.ld.notificator.kafka;

import com.ld.notificator.dto.EventStatusDTO;
import com.ld.notificator.dto.EventToApproveDTO;
import com.ld.notificator.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    @Autowired
    private final EventService eventService;

    @KafkaListener(topics = "notificator",
            groupId = "notificator-listener")
    public void consume(EventStatusDTO eventStatusDTO) {
        eventService.changeEventStatus(eventStatusDTO.getEventStatus(), eventStatusDTO.getId());
    }
}
