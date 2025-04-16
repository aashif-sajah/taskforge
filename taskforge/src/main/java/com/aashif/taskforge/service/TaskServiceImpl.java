package com.aashif.taskforge.service;

import com.aashif.taskforge.model.Task;
import com.aashif.taskforge.model.TaskStatus;
import com.aashif.taskforge.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
    Task existingTask = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task Not Found to Update"));
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setTitle(updatedTask.getTitle());
        return taskRepo.save(existingTask);
    }

    @Override
    // this method need more error handling later
    public void deleteTask(Long id)
    {
        taskRepo.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepo.findByStatus(status);
    }
}
