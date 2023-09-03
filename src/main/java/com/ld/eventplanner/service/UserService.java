package com.ld.eventplanner.service;


import com.ld.eventplanner.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO findUserById(long itemId);

    UserDTO updateUserById(UserDTO userDTO, long userId);

    void deleteUserById(long itemId);
}
