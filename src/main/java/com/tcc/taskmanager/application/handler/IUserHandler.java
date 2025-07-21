package com.tcc.taskmanager.application.handler;

import com.tcc.taskmanager.application.dtos.request.UserRequestDto;
import com.tcc.taskmanager.application.dtos.response.UserResponseDto;

public interface IUserHandler {
    void createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long userId);
}
