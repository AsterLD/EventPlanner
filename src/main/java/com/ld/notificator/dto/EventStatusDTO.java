package com.ld.notificator.dto;

import com.ld.notificator.enums.EventStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
