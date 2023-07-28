package com.ld.notificator.controller;


import com.ld.notificator.dto.UserDTO;
import com.ld.notificator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @PutMapping(value = "/user/{id}/update")
    public UserDTO updateUserById(@PathVariable("id") Long userId, @RequestBody UserDTO userDTO) {
        return userService.updateUserById(userDTO, userId);
    }

    @DeleteMapping("/user/{id}/delete")
    public long deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return userId;
    }

}
