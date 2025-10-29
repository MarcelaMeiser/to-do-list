package com.meiser.to_do_list.controller;

import com.meiser.to_do_list.model.Task;
import com.meiser.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define que está classe é um Controller Rest
// (retorna dados no formato JSON por padrão)
@RestController
// URL base para todos os endpoints deste controller
@RequestMapping("/api/vi/tasks")
public class TaskController {

    // Pede ao Spring para injetar uma instância do TaskService "o cérebro" por trás das lógicas de negócio
    @Autowired
    private TaskService taskService;

    // Endpoint 1:
    // Mapeia para POST /api/v1/tasks
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED); // Retorna 201 Created
    }

    // Endpoint 2:
    // Mapeia para POST /api/v1/tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK); // Retorna 200 OK
    }
}