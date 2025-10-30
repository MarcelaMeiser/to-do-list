package com.meiser.to_do_list;

import com.meiser.to_do_list.model.Task;
import com.meiser.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

	public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // Código a ser executado após a inicialização do aplicativo
        Scanner sc = new Scanner(System.in);

        //Loop infinito para manter o menu rodando
        while (true) {
            exibirMenu();
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    adicionarTarefa(sc);
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    buscarTarefaPorId(sc);
                    break;
                case 4:
                    marcarTarefaComoCompleta(sc);
                    break;
                case 5:
                    deletarTarefaPorId(sc);
                    break;
                case 6:
                    System.out.println("Saindo do menu...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void deletarTarefaPorId(Scanner sc) {
        System.out.print("Digite o ID da tarefa a ser deletada: ");
        Long id = sc.nextLong();
        try {
            taskService.deleteTask(id);
            System.out.println("Tarefa (ID: " + id + ") deletada com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void marcarTarefaComoCompleta(Scanner sc) {
        System.out.print("Digite o ID da tarefa a ser completada: ");
        Long id = sc.nextLong();
        try {
            Task task = taskService.markTaskAsCompleted(id);
            System.out.println("Tarefa marcada como completa: " + task.getDescription());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarTarefaPorId(Scanner scanner) {
        System.out.println("\n--- Buscar Tarefa por ID ---");
        System.out.print("Digite o ID da tarefa: ");
        Long id = scanner.nextLong();
        try {
            Task task = taskService.getTaskById(id);
            System.out.println("Tarefa encontrada: " + task);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Ex: "Tarefa não encontrada..."
        }
    }

    private void listarTarefas() {
        System.out.println("\n--- Lista de Tarefas ---");
        taskService.getAllTasks().forEach(task -> {
            System.out.printf("[%s] %s (ID: %d, Criada em: %s)\n",
                    task.isCompleted() ? "X" : " ",
                    task.getDescription(),
                    task.getId(),
                    task.getCreatedAt().toString().substring(0, 16) // Formatação simples
            );
        });
        System.out.println("-------------------------");
    }


    private void adicionarTarefa(Scanner sc) {
        System.out.println("=== Adicionar Tarefa ===");
        System.out.println("Digite a descrição da Tarefa: ");
        String descricao = sc.nextLine();
        // Lógica para adicionar a tarefa usando taskService
        Task novaTask = new Task();
        novaTask.setDescription(descricao);
        Task tarefaCriada = taskService.createTask(novaTask);
        System.out.println("Tarefa adicionada com sucesso! ID; " + tarefaCriada.getId());
    }

    private void exibirMenu() {
        System.out.println("=== To-Do List Menu ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Buscar Tarefa por ID");
        System.out.println("4. Marcar Tarefa como completa");
        System.out.println("5. Deletar Tarefa por ID");
        System.out.println("6. Sair do Menu");
        System.out.print("Escolha uma opção: ");
    }
}
