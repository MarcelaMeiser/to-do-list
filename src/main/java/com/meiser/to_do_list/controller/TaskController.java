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
    public ResponseEntity<Task> createTask(@RequestBody Task task) { // Diz ao Spring para converter o JSON recebido em um objeto
        Task createdTask = taskService.createTask(task); // Chama o serviço para criar a tarefa
        // Retorna a tarefa criada com o status HTTP 201 Created
        // O primeiro atributo define o conteúdo da resposta
        // O segundo atributo informa ao cliente o resultado da operação (status HTTP apropriado)
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED); // Retorna 201 Created
    }

    // Endpoint 2:
    // indica que esse metodo responde a requisições HTTP GET no caminho /api/vi/tasks.
    @GetMapping
    // define o metodo que retorna uma resposta HTTP contendo uma lista de tarefas
    public ResponseEntity<List<Task>> getAllTasks() {
        // chama o serviço para buscar todas as tarefas no sistema
        List<Task> tasks = taskService.getAllTasks();
        // retorna a lista de tarefas no corpo da resposta e o status HTTP 200 (OK), indicando sucesso
        return new ResponseEntity<>(tasks, HttpStatus.OK); // Retorna 200 OK
    }

    // Endpoint 3:
    // Mapeia para GET /api/v1/tasks/{id}
    // PathVariable pega o valor da URL (o {id} e o injeta na variável Long id do metodo
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // Endpoint 4:
    // Mapeia para PATCH /api/v1/tasks/{id}/complete
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long id) {
        Task updatedTask = taskService.markTaskAsCompleted(id);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}