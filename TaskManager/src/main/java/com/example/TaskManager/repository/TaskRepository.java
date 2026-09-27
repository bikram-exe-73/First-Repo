package com.example.TaskManager.repository;

import com.example.TaskManager.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TaskRepository {
    ResponseEntity<Task> save(Task task);
     Map<Integer, Task> getAllTasks();
     Task getTaskById(Integer id);
     void deleteTask(Integer id);
     Task updateTask(Task task);
}
