package com.tejaswinni.taskwizard.controller;

import com.tejaswinni.taskwizard.model.Task;
import com.tejaswinni.taskwizard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Task> getUserTasks(@RequestParam UUID userId) {
        return taskRepository.findByUserId(userId);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}