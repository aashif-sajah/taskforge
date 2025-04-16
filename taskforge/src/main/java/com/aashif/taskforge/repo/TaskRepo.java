package com.aashif.taskforge.repo;

import com.aashif.taskforge.model.Task;
import com.aashif.taskforge.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
