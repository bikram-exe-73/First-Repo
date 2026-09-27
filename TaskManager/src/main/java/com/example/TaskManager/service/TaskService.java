package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TaskService {
    ResponseEntity<Task> save(Task task);
     Map<Integer, Task> getAllTasks();
     Task getTaskById(Integer id);
     void deleteTask(Integer id);
     Task markTaskAsCompleted(Integer id);
     Task updateTask(Task task);
}
