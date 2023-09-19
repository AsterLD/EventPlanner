package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.entity.Event;

import java.util.Objects;

public class Updater {
    public static void UpdateEvent(Event event, EventDTO eventDTO) {
        if (Objects.nonNull(eventDTO)) {
            if (Objects.nonNull(eventDTO.getName())) {
                event.setName(eventDTO.getName());
            } if (Objects.nonNull(eventDTO.getType())) {
                event.setType(eventDTO.getType());
            } if (Objects.nonNull(eventDTO.getEventDate())) {
                event.setEventDate(eventDTO.getEventDate());
            }
        }
    }
}
