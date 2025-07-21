package com.tcc.taskmanager.domain.spi.persistence;

import com.tcc.taskmanager.domain.models.Task;
import java.util.List;

public interface ITaskPersistencePort {
    void createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    void updateTask(Task task);
    void deleteTask(Long id);
}
