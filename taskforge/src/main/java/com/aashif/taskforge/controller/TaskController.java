package com.aashif.taskforge.controller;

import com.aashif.taskforge.model.Task;
import com.aashif.taskforge.model.TaskStatus;
import com.aashif.taskforge.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create a task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    // Get all Saved Tasks
    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }


    // Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // Update a Task
    @PutMapping("/{id}")
    public  ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    //  DELETE task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Filter tasks by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }
}
