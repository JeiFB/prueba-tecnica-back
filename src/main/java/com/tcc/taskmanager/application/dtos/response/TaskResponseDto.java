package com.tcc.taskmanager.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
} 