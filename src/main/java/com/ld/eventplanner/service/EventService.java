package com.ld.eventplanner.service;

import com.ld.eventplanner.dto.ReturnableEventDTO;
import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.enums.EventStatus;

import java.util.List;

public interface EventService {

    ReturnableEventDTO getEventById(Long eventId);

    List<ReturnableEventDTO> getAllEvents(Integer page, Integer pageSize);

    SavableEventDTO createEvent(SavableEventDTO event);

    String approveEvent(Long eventId);

    void changeEventStatus(EventStatus eventStatus, Long eventId);

    ReturnableEventDTO updateEvent(Long eventId, SavableEventDTO event);

    void deleteEvent(Long eventId);

}
