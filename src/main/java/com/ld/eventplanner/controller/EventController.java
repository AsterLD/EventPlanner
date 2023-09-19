package com.ld.eventplanner.controller;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event/{eventId}")
    public EventDTO getEventById(@PathVariable("eventId") Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/event/all")
    public List<EventDTO> getAllEvents(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return eventService.getAllEvents(page, pageSize);
    }

    @PostMapping("/event")
    public EventDTO createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @PutMapping(value = "/event/{eventId}/approve")
    public String approveEvent(@PathVariable("eventId") Long eventId) {
        return eventService.approveEvent(eventId);
    }

    @PutMapping(value = "/event/{eventId}/update")
    public EventDTO updateEventById(@PathVariable("eventId") Long eventId, @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(eventId, eventDTO);
    }

    @DeleteMapping("/event/{eventId}/delete")
    public long deleteEventById(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return eventId;
    }
}
