package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.ReturnableEventDTO;
import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.dto.EventToApproveDTO;
import com.ld.eventplanner.entity.Event;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static ReturnableEventDTO mapEventToReturnableEventDTO(Event Event) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Event, ReturnableEventDTO.class);
    }

    public static SavableEventDTO mapEventToSaveableEventDTO(Event Event) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Event, SavableEventDTO.class);
    }

    public static EventToApproveDTO mapEventToEventToApproveDTO(Event Event) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(Event, EventToApproveDTO.class);
    }

    public static Event mapEventDTOToEvent(SavableEventDTO SavableEventDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(SavableEventDTO, Event.class);
    }
}
