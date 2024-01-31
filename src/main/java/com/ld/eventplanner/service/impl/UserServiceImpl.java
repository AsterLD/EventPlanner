package com.ld.eventplanner.service.impl;


import com.ld.eventplanner.dto.UserDTO;
import com.ld.eventplanner.entity.User;
import com.ld.eventplanner.exception.UserException;
import com.ld.eventplanner.repo.UserRepository;
import com.ld.eventplanner.service.UserService;
import com.ld.eventplanner.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUserById(UserDTO userDTO, long userId) {
        if (userRepository.existsById(userId)) {
            User editedUser = userMapper.toUser(userDTO);
            editedUser.setId(userId);
            userRepository.save(editedUser);
            return userMapper.toUserDTO(editedUser);
        } else {
            throw new UserException("User with this id not found.");
        }
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
