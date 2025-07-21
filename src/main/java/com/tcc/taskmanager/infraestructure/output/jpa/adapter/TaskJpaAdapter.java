package com.tcc.taskmanager.infraestructure.output.jpa.adapter;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.domain.spi.persistence.ITaskPersistencePort;
import com.tcc.taskmanager.infraestructure.output.jpa.mapper.ITaskEntityMapper;
import com.tcc.taskmanager.infraestructure.output.jpa.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskJpaAdapter implements ITaskPersistencePort {
    private final ITaskRepository taskRepository;
    private final ITaskEntityMapper taskEntityMapper;

    @Override
    public void createTask(Task task) {
        taskRepository.save(taskEntityMapper.toEntity(task));
    }

    @Override
    public Task getTaskById(Long id) {
        return taskEntityMapper.toDomain(taskRepository.getReferenceById(id));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(taskEntityMapper.toEntity(task));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
} 