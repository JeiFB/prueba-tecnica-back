package com.tcc.taskmanager.domain.api;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.application.dtos.request.TaskFilterRequestDto;
import java.util.List;

public interface ITaskServicePort {
    void createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    void updateTask(Task task);
    void deleteTask(Long id);
    List<Task> findTasksByFilters(TaskFilterRequestDto filters);
}
