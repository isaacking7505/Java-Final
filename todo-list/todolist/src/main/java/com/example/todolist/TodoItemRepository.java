package com.example.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    long countAllByCompleted(boolean completed);
    List<TodoItem> findAllByCompleted(boolean completed);
}