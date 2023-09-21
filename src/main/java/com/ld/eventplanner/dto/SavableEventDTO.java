package com.ld.eventplanner.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.eventplanner.enums.EventStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SavableEventDTO {

    @JsonIgnore
    private Long id;

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
