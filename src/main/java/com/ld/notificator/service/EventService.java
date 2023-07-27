package com.ld.notificator.service;

import com.ld.notificator.dto.EventDTO;

public interface EventService {

    EventDTO getEventById(Long eventId);

    EventDTO createEvent(EventDTO event);

    EventDTO updateEvent(Long eventId, EventDTO event);

    void deleteEvent(Long eventId);

}
