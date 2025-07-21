package com.tcc.taskmanager.application.mapper;

import com.tcc.taskmanager.application.dtos.response.TaskResponseDto;
import com.tcc.taskmanager.domain.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITaskResponseMapper {
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "priority", source = "priority")
    TaskResponseDto toResponse(Task task);
} 