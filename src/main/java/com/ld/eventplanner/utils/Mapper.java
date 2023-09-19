package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.EventDTO;
import com.ld.eventplanner.dto.EventToApproveDTO;
import com.ld.eventplanner.entity.Event;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static EventDTO mapEventToEventDTO(Event Event) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Event, EventDTO.class);
    }

    public static EventToApproveDTO mapEventToEventToApproveDTO(Event Event) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Event, EventToApproveDTO.class);
    }

    public static Event mapEventDTOToEvent(EventDTO EventDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(EventDTO, Event.class);
    }
}
