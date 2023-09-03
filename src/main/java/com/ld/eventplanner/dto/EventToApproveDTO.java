package com.ld.eventplanner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventToApproveDTO {

    private Long id;

    private String type;

    private LocalDate eventDate;

    private Long userId;

}
