package com.example.TaskManager.repository;

import com.example.TaskManager.model.Task;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    public Map<Integer, Task> taskEntry = new HashMap<Integer, Task>();

    @Override
    public ResponseEntity<Task> save(Task task){
        taskEntry.put(task.getT_Id(), task);
       return ResponseEntity.ok(task);
    }

    @Override
    public Map<Integer, Task> getAllTasks() {
        return taskEntry;
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskEntry.get(id);
    }

    @Override
    public void deleteTask(Integer id) {
         taskEntry.remove(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskEntry.put(task.getT_Id(), task);
    }

}
