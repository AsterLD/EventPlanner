package com.ld.eventplanner.service.impl;

import com.ld.eventplanner.dto.ReturnableEventDTO;
import com.ld.eventplanner.dto.SavableEventDTO;
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
    public ReturnableEventDTO getEventById(Long eventId) {
        return Mapper.mapEventToReturnableEventDTO(eventRepository.findById(eventId).orElseThrow());
    }

    @Override
    public List<ReturnableEventDTO> getAllEvents(Integer page, Integer pageSize) {
        List<Event> eventList = eventRepository.findAll(PageRequest.of(page - 1, pageSize)).getContent();
        return eventList.stream().map(Mapper::mapEventToReturnableEventDTO).collect(Collectors.toList());
    }

    @Override
    public SavableEventDTO createEvent(SavableEventDTO savableEventDTO) {
        eventRepository.save(Mapper.mapEventDTOToEvent(savableEventDTO));
        return savableEventDTO;
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
    public ReturnableEventDTO updateEvent(Long eventId, SavableEventDTO savableEventDTO) {
        if (eventRepository.existsById(eventId)) {
            Event event = eventRepository.findById(eventId).orElseThrow();
            Updater.UpdateEvent(event, savableEventDTO);
            eventRepository.save(event);
            return Mapper.mapEventToReturnableEventDTO(event);
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.delete(eventRepository.findById(eventId).orElseThrow());
        } else {
            throw new EventException("Event with this id not found.");
        }
    }

}
