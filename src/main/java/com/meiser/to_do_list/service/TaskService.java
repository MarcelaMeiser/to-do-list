package com.meiser.to_do_list.service;

import com.meiser.to_do_list.model.Task;
import com.meiser.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    /**
     * Busca uma tarefa pelo seu ID.
     * @param id O ID da tarefa a ser buscada.
     * @return A tarefa encontrada.
     * @throws ResponseStatusException se a tarefa não for encontrada (erro 404).
     */
    // O findById do JpaRepository não retorna Task diretamente. Ele retorna um Optional
    // que é uma forma moderna no Java de lidar com valores que podem estar ausentes (NullPointerException).
    // .orElseThrow() é um metodo do Optional que permite especificar uma ação a ser tomada
    // RespondeStatusException é uma exceção especial do Spring que, quando lançada,
    // resulta numa resposta HTTP com o status especificado (neste caso, 404 Not Found).
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com o ID: " + id));
    }

    // Marca uma tarefa como concluída
    // Busca a tarefa pelo ID, atualiza o campo 'completed' para true
    // e salva a tarefa atualizada no banco de dados.
    public Task markTaskAsCompleted(Long id) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setCompleted(true);
        return taskRepository.save(taskToUpdate);
    }

    // Deleta uma tarefa pelo ID
    // Busca a tarefa pelo ID e a remove do banco de dados.
    // Se a tarefa não for encontrada, lança uma exceção 404.
    public void deleteTask(Long id) {
        Task taskToDelete = getTaskById(id);
        taskRepository.delete(taskToDelete);
    }

}
