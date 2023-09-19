package com.ld.eventplanner.service;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.enums.EventStatus;

import java.util.List;

public interface EventService {

    EventDTO getEventById(Long eventId);

    List<EventDTO> getAllEvents(Integer page, Integer pageSize);

    EventDTO createEvent(EventDTO event);

    String approveEvent(Long eventId);

    void changeEventStatus(EventStatus eventStatus, Long eventId);

    EventDTO updateEvent(Long eventId, EventDTO event);

    void deleteEvent(Long eventId);

}
