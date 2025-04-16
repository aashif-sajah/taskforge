package com.aashif.taskforge.service;

import com.aashif.taskforge.model.Task;
import com.aashif.taskforge.model.TaskStatus;
import com.aashif.taskforge.repo.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskServiceImplTest {

    private TaskRepo taskRepository;
    private TaskService taskServiceImpl;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepo.class); // Mock the repo
        taskServiceImpl = new TaskServiceImpl(taskRepository); // Inject manually
    }


    @Test
    void createTask()
    {
        Task task = new Task(null, "Test Task", "Desc", TaskStatus.PENDING);
        Task savedTask = new Task(1L, "Test Task", "Desc", TaskStatus.PENDING);

        when(taskRepository.save(task)).thenReturn(savedTask);

        Task result = taskServiceImpl.createTask(task);
        assertEquals(1L, result.getId());

      }

    @Test
    void updateTask()
    {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "T1", "D1", TaskStatus.PENDING),
                new Task(2L, "T2", "D2", TaskStatus.DONE)
        );

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskServiceImpl.getAllTasks();
        assertEquals(2, result.size());
      }

    @Test
    void getTaskById()
    {
        Task task = new Task(1L, "T1", "D1", TaskStatus.PENDING);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task result = taskServiceImpl.getTaskById(1L);
        assertEquals("T1", result.getTitle());
      }

}