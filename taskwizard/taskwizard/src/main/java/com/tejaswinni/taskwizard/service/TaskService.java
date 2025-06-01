package com.tejaswinni.taskwizard.service;

import com.tejaswinni.taskwizard.model.Task;
import com.tejaswinni.taskwizard.repository.TaskRepository;
import com.tejaswinni.taskwizard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // Add Task Method
    public Task addTask(Task task) {
        // Validate if the user associated with the task exists
        if (!userRepository.existsById(task.getUser().getId())) {
            throw new IllegalArgumentException("User ID does not exist: " + task.getUser().getId());
        }
        // Save the task to the database
        return taskRepository.save(task);
    }

    // Other existing methods
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + id));
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}