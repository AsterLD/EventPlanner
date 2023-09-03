package com.ld.eventplanner.dto;

import com.ld.eventplanner.enums.EventStatus;
import lombok.Data;

@Data
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
