package com.meiser.to_do_list.model;

// Importações necessárias
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

// Anotação Lombok para gerar getters, setters, toString, etc.
@Data

// Marca a classe como uma entidade JPA, ou seja,
// ela será mapeada para uma tabela no banco de dados
@Entity

// Define o nome da tabela no banco de dados
@Table(name = "tasks")

public class Task {
    // Indica que este campo é a chave primária da entidade (Long id)
    @Id

    // Define que o valor do campo será gerado automaticamente pelo banco de dados,
    // usando a estratégia de identidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Um campo booleano que indica se a tarefa foi concluída ou não
    // Inicializa como false por padrão
    private boolean completed = false;

    // Define que este campo não pode ser atualizado após ser inserido no banco.
    // Isso é útil para garantir que a data de criação permaneça imutável
    @Column(updatable = false) // Não deixa atualizar este campo
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String description;

    // Metodo a ser executado ANTES de salvar no banco pela primeira vez
    // Define a data e hora atual para o campo createdAt
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}