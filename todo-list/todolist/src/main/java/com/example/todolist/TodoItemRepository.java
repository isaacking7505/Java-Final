package com.example.todolist;

import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    long countAllByCompleted(boolean completed);

    // Removed the custom save method to avoid conflict with CrudRepository
}