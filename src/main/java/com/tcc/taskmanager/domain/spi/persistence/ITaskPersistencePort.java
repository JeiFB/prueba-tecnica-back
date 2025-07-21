package com.tcc.taskmanager.domain.spi.persistence;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.application.dtos.request.TaskFilterRequestDto;
import java.util.List;

public interface ITaskPersistencePort {
    void createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    void updateTask(Task task);
    void deleteTask(Long id);
    List<Task> findTasksByFilters(TaskFilterRequestDto filters);
}
