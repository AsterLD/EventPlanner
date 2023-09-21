package com.ld.eventplanner.controller;

import com.ld.eventplanner.dto.ReturnableEventDTO;
import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event/{eventId}")
    public ReturnableEventDTO getEventById(@PathVariable("eventId") Long eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/event/all")
    public List<ReturnableEventDTO> getAllEvents(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return eventService.getAllEvents(page, pageSize);
    }

    @PostMapping("/event")
    public SavableEventDTO createEvent(@RequestBody SavableEventDTO savableEventDTO) {
        return eventService.createEvent(savableEventDTO);
    }

    @PutMapping(value = "/event/{eventId}/approve")
    public String approveEvent(@PathVariable("eventId") Long eventId) {
        return eventService.approveEvent(eventId);
    }

    @PutMapping(value = "/event/{eventId}/update")
    public ReturnableEventDTO updateEventById(@PathVariable("eventId") Long eventId, @RequestBody SavableEventDTO savableEventDTO) {
        return eventService.updateEvent(eventId, savableEventDTO);
    }

    @DeleteMapping("/event/{eventId}/delete")
    public long deleteEventById(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return eventId;
    }
}
