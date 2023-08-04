package com.ld.notificator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.notificator.enums.EventStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("event_status")
    private EventStatus eventStatus;

    @JsonProperty("event_date")
    private LocalDate eventDate;

    @JsonProperty("user_id")
    private Long userId;

}