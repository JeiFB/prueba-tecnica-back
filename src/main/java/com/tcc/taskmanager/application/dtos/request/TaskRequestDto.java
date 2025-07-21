package com.tcc.taskmanager.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    @NotBlank
    private String title;
    private String description;
}
