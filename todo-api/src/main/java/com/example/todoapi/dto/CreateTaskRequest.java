package com.example.todoapi.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class CreateTaskRequest {
    @NotBlank @Size(max = 200)
    private String title;

    @Size(max = 2000)
    private String description;

    @Min(1) @Max(5)
    private Integer priority;

    private LocalDate dueDate;

    // getters/setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
