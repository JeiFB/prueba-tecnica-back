package com.tcc.taskmanager.infraestructure.output.jpa.mapper;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.infraestructure.output.jpa.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITaskEntityMapper {
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "priority", source = "priority")
    TaskEntity toEntity(Task task);
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "priority", source = "priority")
    Task toDomain(TaskEntity entity);
} 