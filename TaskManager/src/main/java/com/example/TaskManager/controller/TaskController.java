package com.example.TaskManager.controller;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
@RequestMapping("/task")
public class TaskController {

    public TaskService taskService;
    public int currentId=1;
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task request){
        Task task  = new Task(
                request.getT_Title(),
                request.getDueDate(),
                request.getDescription()
        );
        return taskService.save(task);
    }

    @GetMapping("/get")
    public Map<Integer, Task> getAllTask(){
        return  taskService.getAllTasks();
    }
    @GetMapping("/get/{id}")
    public Task getTaskById(@PathVariable Integer id){
          return taskService.getTaskById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id){
         taskService.deleteTask(id);
         return "Deleted Successfully";
    }
    @PutMapping("/markCompletedTask/{id}")
    public Task markTaskAsCompleted(@PathVariable Integer id){
         return taskService.markTaskAsCompleted(id);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@PathVariable Integer id , @RequestBody Task request){
        Task existingtask = taskService.getTaskById(id);
        if (existingtask == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found with ID: " + id);
        }
        existingtask.setT_Title(request.getT_Title());
        existingtask.setDueDate(request.getDueDate());
        existingtask.setDescription(request.getDescription());
        existingtask.setCompleted(existingtask.isCompleted());

       return  taskService.updateTask(existingtask);

    }


}
