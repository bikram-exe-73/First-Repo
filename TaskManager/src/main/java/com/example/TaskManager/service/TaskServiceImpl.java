package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    public int currentId=1;
    @Override
    public ResponseEntity<Task> save(Task task) {
        task.setT_Id(currentId++);
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    @Override
    public Map<Integer, Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public void deleteTask(Integer id) {
         taskRepository.deleteTask(id);
    }

    @Override
    public Task markTaskAsCompleted(Integer id) {
        Task task = taskRepository.getTaskById(id);
        if(task!=null){
            task.setCompleted(true);
            return taskRepository.updateTask(task);
        }
        return  null;
    }

    @Override
    public Task  updateTask( Task task) {
        return taskRepository.updateTask(task);
    }

}
