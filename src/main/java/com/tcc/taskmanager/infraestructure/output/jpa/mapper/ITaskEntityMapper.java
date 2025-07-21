package com.tcc.taskmanager.infraestructure.output.jpa.mapper;

import com.tcc.taskmanager.domain.models.Task;
import com.tcc.taskmanager.infraestructure.output.jpa.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITaskEntityMapper {
    TaskEntity toEntity(Task task);
    Task toDomain(TaskEntity entity);
} 