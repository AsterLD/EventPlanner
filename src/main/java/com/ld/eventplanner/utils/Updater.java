package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.entity.Event;

import java.util.Objects;

public class Updater {
    public static void UpdateEvent(Event event, SavableEventDTO savableEventDTO) {
        if (Objects.nonNull(savableEventDTO)) {
            if (Objects.nonNull(savableEventDTO.getName())) {
                event.setName(savableEventDTO.getName());
            } if (Objects.nonNull(savableEventDTO.getType())) {
                event.setType(savableEventDTO.getType());
            } if (Objects.nonNull(savableEventDTO.getEventDate())) {
                event.setEventDate(savableEventDTO.getEventDate());
            }
        }
    }
}
