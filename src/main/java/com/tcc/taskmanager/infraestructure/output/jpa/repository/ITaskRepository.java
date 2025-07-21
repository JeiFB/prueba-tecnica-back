package com.tcc.taskmanager.infraestructure.output.jpa.repository;

import com.tcc.taskmanager.infraestructure.output.jpa.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {
} 