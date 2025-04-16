package com.aashif.taskforge.service;

import com.aashif.taskforge.model.Task;
import com.aashif.taskforge.model.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> getTasksByStatus(TaskStatus status);
}
