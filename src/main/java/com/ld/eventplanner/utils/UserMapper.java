package com.ld.eventplanner.utils;

import com.ld.eventplanner.dto.UserDTO;
import com.ld.eventplanner.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toUserDTO(User source);

    User toUser(UserDTO source);
}
