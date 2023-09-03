package com.ld.eventplanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

}
