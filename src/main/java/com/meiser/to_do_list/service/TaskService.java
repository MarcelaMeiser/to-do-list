package com.meiser.to_do_list.service;

import com.meiser.to_do_list.model.Task;
import com.meiser.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Marca a classe como um serviço do Spring - "Componente de serviço"
public class TaskService {
    // Aqui você pode adicionar métodos para manipular tarefas,
    // como criar, atualizar, excluir e buscar tarefas.

    //Injeção de Dependência: Pede ao Spring para "nos dar" o repositório
    @Autowired
    private TaskRepository taskRepository;

    // Metodo para criar uma tarefa
    public Task createTask(Task task) {
        // Aqui poderiam ter regras de negócio
        // Exemplo: if(task.getDescription().isEmpty()) { .... }
        return taskRepository.save(task);
    }

    // Metodo para listar todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
