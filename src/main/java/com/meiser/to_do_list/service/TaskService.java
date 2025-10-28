package com.meiser.to_do_list.service;

import com.meiser.to_do_list.model.Task;
import com.meiser.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// LÓGICAS DE NEGÓCIO:
// Lógicas de negócio são as regras e operações que definem como os dados devem
// ser processados e manipulados para atender aos requisitos da aplicação.
// Elas representam o comportamento esperado do sistema e geralmente ficam na camada de serviço
// (Service) numa aplicação com arquitetura em camadas.

// Isso indica que ela contém a lógica de negócios da aplicação
// e será gerenciada pelo Spring como um bean.
// Serviços são usados para implementar regras de negócio e intermediar entre
// os controladores e os repositórios.
// Marca a classe como um serviço do Spring - "Componente de serviço"
@Service
public class TaskService {
    // Aqui você pode adicionar métodos para manipular tarefas,
    // como criar, atualizar, excluir e buscar tarefas.

    // @Autowired: realiza a injeção de dependência.
    // O Spring automaticamente fornece uma instância do TaskRepository para ser usada nesta classe.
    // O TaskRepository é usado para acessar os dados da entidade Task no banco de dados.
    //Injeção de Dependência: Pede ao Spring para "nos dar" o repositório
    @Autowired
    private TaskRepository taskRepository;

    // Metodo para criar uma tarefa
    // Recebe um objeto Task como entrada.
    // Logica: Aqui poderiam ser adicionadas regras de negócio, como validações.
    // Exemplo: if(task.getDescription().isEmpty()) { .... }
    // Retorno: Chama o metodo save do TaskRepository para salvar a tarefa no banco
    // e retorna a tarefa salva (com ‘ID’ gerado).
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Metodo para listar todas as tarefas
    // Logica: Usa o metodo findAll do TaskRepository para buscar todas as tarefas no banco.
    // Retorno: Retorna uma lista de todas as tarefas encontradas.
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}
