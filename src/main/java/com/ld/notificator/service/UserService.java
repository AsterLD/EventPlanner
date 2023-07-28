package com.ld.notificator.service;


import com.ld.notificator.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO findUserById(long itemId);

    UserDTO updateUserById(UserDTO userDTO, long userId);

    void deleteUserById(long itemId);
}
