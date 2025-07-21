package com.tcc.taskmanager.application.mapper;

import com.tcc.taskmanager.application.dtos.request.TaskRequestDto;
import com.tcc.taskmanager.domain.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITaskRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "completed", constant = "false")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    Task toTask(TaskRequestDto dto);
} 