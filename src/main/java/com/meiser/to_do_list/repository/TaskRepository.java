package com.meiser.to_do_list.repository;

import com.meiser.to_do_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional (o JpaRepository já informa ao Spring)
public interface TaskRepository extends JpaRepository<Task, Long> {
    // A mágica acontece aqui.
    // Métodos como save(), findById(), findAll(), deleteById()
    // são "herdados" gratuitamente.
}