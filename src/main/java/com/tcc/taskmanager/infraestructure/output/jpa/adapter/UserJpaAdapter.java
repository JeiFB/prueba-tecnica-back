package com.tcc.taskmanager.infraestructure.output.jpa.adapter;

import com.tcc.taskmanager.domain.models.User;
import com.tcc.taskmanager.domain.spi.persistence.IUserPersistencePort;
import com.tcc.taskmanager.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper iUserEntityMapper;
    @Override
    public void createUser(User user) {
        userRepository.save(iUserEntityMapper.toEntity(user));
    }

    @Override
    public User getUserById(Long userId) {
        return iUserEntityMapper.toDomain(userRepository.getReferenceById(userId));
    }
}
