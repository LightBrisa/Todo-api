package com.example.todoapi.service;

import com.example.todoapi.dto.CreateTaskRequest;
import com.example.todoapi.dto.TaskResponse;
import com.example.todoapi.dto.UpdateTaskRequest;
import com.example.todoapi.entity.Task;
import com.example.todoapi.entity.TaskStatus;
import com.example.todoapi.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) { this.repo = repo; }

    public TaskResponse create(CreateTaskRequest req) {
        Task t = new Task();
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        t.setPriority(req.getPriority());
        t.setDueDate(req.getDueDate());
        t.setStatus(TaskStatus.TODO);
        return toResp(repo.save(t));
    }

    public TaskResponse get(Long id) {
        return toResp(find(id));
    }

    public Page<TaskResponse> list(Pageable pageable) {
        return repo.findAll(pageable).map(this::toResp);
    }

    public TaskResponse update(Long id, UpdateTaskRequest req) {
        Task t = find(id);
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        t.setPriority(req.getPriority());
        t.setDueDate(req.getDueDate());
        return toResp(repo.save(t));
    }

    public void delete(Long id) {
        repo.delete(find(id));
    }

    private Task find(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Task " + id + " not found"));
    }

    private TaskResponse toResp(Task t) {
        return new TaskResponse(
                t.getId(), t.getTitle(), t.getDescription(), t.getStatus(),
                t.getPriority(), t.getDueDate(), t.getCreatedAt(), t.getUpdatedAt()
        );
    }
}
