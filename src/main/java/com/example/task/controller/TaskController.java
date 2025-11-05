package com.example.task.controller;

import com.example.task.service.TaskService;
import com.example.task.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController // -> la classe renvoie directement du JSON.
@RequestMapping("/tasks") //→ base de toutes les routes de cette classe.
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;


        taskService.addTask("Tache 1");
        taskService.addTask("Tache 2");
    }

//Route GET pour récupérer toutes les tâches
    @GetMapping("/hello") // → route GET à l’adresse /tasks.
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Welcome to the Task Manager API!");
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){ // → permet de retourner la liste + le statut HTTP 200 OK.
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, String> payload){
        String description = payload.get("description");
        Task task = taskService.addTask(description);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
