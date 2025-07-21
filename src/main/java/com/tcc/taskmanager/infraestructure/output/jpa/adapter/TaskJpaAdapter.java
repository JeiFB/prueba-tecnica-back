package com.tcc.taskmanager.infraestructure.output.jpa.adapter;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.domain.spi.persistence.ITaskPersistencePort;
import com.tcc.taskmanager.infraestructure.output.jpa.entity.TaskEntity;
import com.tcc.taskmanager.infraestructure.output.jpa.entity.UserEntity;
import com.tcc.taskmanager.infraestructure.output.jpa.mapper.ITaskEntityMapper;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.ITaskRepository;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskJpaAdapter implements ITaskPersistencePort {
    private final ITaskRepository taskRepository;
    private final ITaskEntityMapper taskEntityMapper;
    private final IUserRepository userRepository;

    @Override
    public void createTask(Task task) {
        TaskEntity entity = taskEntityMapper.toEntity(task);
        if (task.getUserId() != null) {
            UserEntity user = userRepository.findById(task.getUserId()).orElse(null);
            entity.setUser(user);
        } else {
            entity.setUser(null);
        }
        taskRepository.save(entity);
    }

    @Override
    public Task getTaskById(Long id) {
        TaskEntity entity = taskRepository.getReferenceById(id);
        if (entity.getUser() != null) {
            entity.getUser().getName(); // Fuerza la carga del usuario
        }
        return taskEntityMapper.toDomain(entity);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll().stream()
            .peek(entity -> {
                if (entity.getUser() != null) {
                    entity.getUser().getName(); // Fuerza la carga del usuario
                }
            })
            .map(taskEntityMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void updateTask(Task task) {
        TaskEntity entity = taskEntityMapper.toEntity(task);
        if (task.getUserId() != null) {
            UserEntity user = userRepository.findById(task.getUserId()).orElse(null);
            entity.setUser(user);
        } else {
            entity.setUser(null);
        }
        taskRepository.save(entity);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
} 