package com.tcc.taskmanager.application.handler;

import com.tcc.taskmanager.application.dtos.request.TaskRequestDto;
import com.tcc.taskmanager.application.dtos.response.TaskResponseDto;
import java.util.List;

public interface ITaskHandler {
    void createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto getTaskById(Long id);
    List<TaskResponseDto> getAllTasks();
    void updateTask(Long id, TaskRequestDto taskRequestDto);
    void deleteTask(Long id);
} 