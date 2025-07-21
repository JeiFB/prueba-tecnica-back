package com.tcc.taskmanager.domain.api;

import com.tcc.taskmanager.domain.models.User;

public interface IUserServicePort {
    void createUser(User user);
    User getUserById(Long userId);
}
