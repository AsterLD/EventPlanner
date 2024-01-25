package com.ld.eventplanner.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.eventplanner.enums.EventStatus;

import java.time.LocalDate;


public record SavableEventDTO(@JsonIgnore Long id, @JsonProperty("name") String name,
                              @JsonProperty("type") String type,
                              @JsonProperty("event_status") EventStatus eventStatus,
                              @JsonProperty("event_date") LocalDate eventDate,
                              @JsonProperty("user_id") Long userId) {

}
