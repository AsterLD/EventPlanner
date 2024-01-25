package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.entity.Event;

import java.util.Objects;

public class Updater {
    public static void UpdateEvent(Event event, SavableEventDTO savableEventDTO) {
        if (Objects.nonNull(savableEventDTO)) {
            if (Objects.nonNull(savableEventDTO.name())) {
                event.setName(savableEventDTO.name());
            } if (Objects.nonNull(savableEventDTO.type())) {
                event.setType(savableEventDTO.type());
            } if (Objects.nonNull(savableEventDTO.eventDate())) {
                event.setEventDate(savableEventDTO.eventDate());
            }
        }
    }
}
