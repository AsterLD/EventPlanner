package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.EventToApproveDTO;
import com.ld.eventplanner.dto.ReturnableEventDTO;
import com.ld.eventplanner.dto.SavableEventDTO;
import com.ld.eventplanner.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    ReturnableEventDTO toReturnableEventDTO(Event Event);

    SavableEventDTO toSavableEventDTO(Event Event);

    EventToApproveDTO toEventToApproveDTO(Event Event);

    Event toEvent(SavableEventDTO SavableEventDTO);
}
