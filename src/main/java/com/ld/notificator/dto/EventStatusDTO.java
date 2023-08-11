package com.ld.notificator.dto;

import com.ld.notificator.enums.EventStatus;
import lombok.Data;

@Data
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
