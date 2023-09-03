package com.ld.eventplanner.service;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.enums.EventStatus;

public interface EventService {

    EventDTO getEventById(Long eventId);

    EventDTO createEvent(EventDTO event);

    String approveEvent(Long eventId);

    String changeEventStatus(EventStatus eventStatus, Long eventId);

    EventDTO updateEvent(Long eventId, EventDTO event);

    void deleteEvent(Long eventId);

}
