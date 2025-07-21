package com.tcc.taskmanager.application.handler.impl;

import com.tcc.taskmanager.application.dtos.request.TaskRequestDto;
import com.tcc.taskmanager.application.dtos.response.TaskResponseDto;
import com.tcc.taskmanager.application.handler.ITaskHandler;
import com.tcc.taskmanager.application.mapper.ITaskRequestMapper;
import com.tcc.taskmanager.application.mapper.ITaskResponseMapper;
import com.tcc.taskmanager.domain.api.ITaskServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskHandlerImpl implements ITaskHandler {
    private final ITaskServicePort taskServicePort;
    private final ITaskRequestMapper taskRequestMapper;
    private final ITaskResponseMapper taskResponseMapper;

    @Override
    public void createTask(TaskRequestDto taskRequestDto) {
        taskServicePort.createTask(taskRequestMapper.toTask(taskRequestDto));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return taskResponseMapper.toResponse(taskServicePort.getTaskById(id));
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskServicePort.getAllTasks().stream()
                .map(taskResponseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTask(Long id, TaskRequestDto taskRequestDto) {
        var task = taskRequestMapper.toTask(taskRequestDto);
        task.setId(id);
        taskServicePort.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskServicePort.deleteTask(id);
    }
} 