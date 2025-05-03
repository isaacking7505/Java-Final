package com.example.todolist;

import jakarta.validation.constraints.NotBlank;

public class TodoItemFormData {
    @NotBlank
    private String title;

    // Required no-arg constructor
    public TodoItemFormData() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}