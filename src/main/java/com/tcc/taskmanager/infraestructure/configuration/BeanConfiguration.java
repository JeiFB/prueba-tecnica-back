package com.tcc.taskmanager.infraestructure.configuration;

import com.tcc.taskmanager.domain.api.IUserServicePort;
import com.tcc.taskmanager.domain.spi.persistence.IUserPersistencePort;
import com.tcc.taskmanager.domain.usecase.UserUseCase;
import com.tcc.taskmanager.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.tcc.taskmanager.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.IUserRepository;

import com.tcc.taskmanager.domain.api.ITaskServicePort;
import com.tcc.taskmanager.domain.spi.persistence.ITaskPersistencePort;
import com.tcc.taskmanager.domain.usecase.TaskUseCase;
import com.tcc.taskmanager.infraestructure.output.jpa.adapter.TaskJpaAdapter;
import com.tcc.taskmanager.infraestructure.output.jpa.mapper.ITaskEntityMapper;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.ITaskRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    private final ITaskRepository taskRepository;
    private final ITaskEntityMapper taskEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public ITaskPersistencePort taskPersistencePort(
        ITaskRepository taskRepository,
        ITaskEntityMapper taskEntityMapper,
        IUserRepository userRepository
    ) {
        return new TaskJpaAdapter(taskRepository, taskEntityMapper, userRepository);
    }

    @Bean
    public ITaskServicePort taskServicePort(ITaskPersistencePort taskPersistencePort) {
        return new TaskUseCase(taskPersistencePort);
    }
}
