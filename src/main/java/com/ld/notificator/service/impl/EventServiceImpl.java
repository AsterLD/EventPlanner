package com.ld.notificator.service.impl;

import com.ld.notificator.dto.EventDTO;
import com.ld.notificator.dto.EventToApproveDTO;
import com.ld.notificator.entity.Event;
import com.ld.notificator.enums.EventStatus;
import com.ld.notificator.exception.EventException;
import com.ld.notificator.kafka.KafkaProducer;
import com.ld.notificator.repo.EventRepository;
import com.ld.notificator.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private KafkaProducer kafkaProducer;

    private final EventRepository eventRepository;


    @Override
    public EventDTO getEventById(Long eventId) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(eventRepository.findById(eventId).orElseThrow(), EventDTO.class);
    }

    @Override
    public EventDTO createEvent(EventDTO event) {
        ModelMapper modelMapper = new ModelMapper();
        eventRepository.save(modelMapper.map(event, Event.class));
        return event;
    }

    @Override
    public String approveEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            ModelMapper modelMapper = new ModelMapper();
            Event event = eventRepository.findById(eventId).orElseThrow();
            event.setEventStatus(EventStatus.ON_APPROVAL);
            eventRepository.save(event);
            EventToApproveDTO eventToApproveDTO = modelMapper.map(event, EventToApproveDTO.class);
            kafkaProducer.sendMessage(eventToApproveDTO);
            return "Event was successfully sent for approval";
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public String changeEventStatus(EventStatus eventStatus, Long eventId) {
        if (eventRepository.existsById(eventId)) {
            Event event = eventRepository.findById(eventId).orElseThrow();
            event.setEventStatus(eventStatus);
            eventRepository.save(event);
            return "Event status changed successfully";
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public EventDTO updateEvent(Long eventId, EventDTO event) {
        if (eventRepository.existsById(eventId)) {
            ModelMapper modelMapper = new ModelMapper();
            Event editedEvent = modelMapper.map(event, Event.class);
            editedEvent.setId(eventId);
            eventRepository.save(editedEvent);
            return event;
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
