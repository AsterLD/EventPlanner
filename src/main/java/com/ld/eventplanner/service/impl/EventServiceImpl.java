package com.ld.eventplanner.service.impl;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.entity.Event;
import com.ld.eventplanner.enums.EventStatus;
import com.ld.eventplanner.exception.EventException;
import com.ld.eventplanner.kafka.KafkaProducer;
import com.ld.eventplanner.repo.EventRepository;
import com.ld.eventplanner.service.EventService;
import com.ld.eventplanner.utils.Mapper;
import com.ld.eventplanner.utils.Updater;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private KafkaProducer kafkaProducer;

    private final EventRepository eventRepository;


    @Override
    public EventDTO getEventById(Long eventId) {
        return Mapper.mapEventToEventDTO(eventRepository.findById(eventId).orElseThrow());
    }

    @Override
    public List<EventDTO> getAllEvents(Integer page, Integer pageSize) {
        List<Event> eventList = eventRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return eventList.stream().map(Mapper::mapEventToEventDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        eventRepository.save(Mapper.mapEventDTOToEvent(eventDTO));
        return eventDTO;
    }

    @Override
    public String approveEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            Event event = eventRepository.findById(eventId).orElseThrow();
            event.setEventStatus(EventStatus.ON_APPROVAL);
            eventRepository.save(event);
            kafkaProducer.sendMessage(Mapper.mapEventToEventToApproveDTO(event));
            return "Event was successfully sent for approval";
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public void changeEventStatus(EventStatus eventStatus, Long eventId) {
        if (eventRepository.existsById(eventId)) {
            Event event = eventRepository.findById(eventId).orElseThrow();
            event.setEventStatus(eventStatus);
            eventRepository.save(event);
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public EventDTO updateEvent(Long eventId, EventDTO eventDTO) {
        if (eventRepository.existsById(eventId)) {
            Event event = eventRepository.findById(eventId).orElseThrow();
            Updater.UpdateEvent(event, eventDTO);
            eventRepository.save(event);
            return eventDTO;
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        eventRepository.delete(event);
    }

}
