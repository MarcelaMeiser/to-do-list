package com.meiser.to_do_list.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completed = false;

    @Column(updatable = false) // Não deixa atualizar este campo
    private LocalDateTime createdAt;

    @PrePersist // Método a ser executado ANTES de salvar no banco pela primeira vez
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
