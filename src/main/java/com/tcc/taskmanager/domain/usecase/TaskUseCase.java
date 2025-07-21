package com.tcc.taskmanager.domain.usecase;

import com.tcc.taskmanager.application.dtos.request.TaskFilterRequestDto;
import com.tcc.taskmanager.domain.api.ITaskServicePort;
import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.domain.spi.persistence.ITaskPersistencePort;
import java.util.List;

public class TaskUseCase implements ITaskServicePort {
    private final ITaskPersistencePort taskPersistencePort;

    public TaskUseCase(ITaskPersistencePort taskPersistencePort) {
        this.taskPersistencePort = taskPersistencePort;
    }

    @Override
    public void createTask(Task task) {
        taskPersistencePort.createTask(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskPersistencePort.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskPersistencePort.getAllTasks();
    }

    @Override
    public void updateTask(Task task) {
        taskPersistencePort.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskPersistencePort.deleteTask(id);
    }

    @Override
    public List<Task> findTasksByFilters(TaskFilterRequestDto filters) {
        return taskPersistencePort.findTasksByFilters(filters);
    }
} 