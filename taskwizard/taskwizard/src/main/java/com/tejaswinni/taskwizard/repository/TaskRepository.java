package com.tejaswinni.taskwizard.repository;

import com.tejaswinni.taskwizard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for Task Entity.
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByUserId(UUID userId); // Fetch tasks by user ID
}