package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class TodoItemController {
    private final TodoItemRepository repository;

    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("item", new TodoItemFormData());
        model.addAttribute("todos", repository.findAll());
        model.addAttribute("totalNumberOfItems", repository.count());
        model.addAttribute("numberOfActiveItems", repository.countAllByCompleted(false));
        return "index";
    }

    @PostMapping
    public String addTodo(@Valid @ModelAttribute("item") TodoItemFormData formData) {
        repository.save(new TodoItem(formData.getTitle(), false));
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTodo(@PathVariable Long id) {
        TodoItem todo = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID"));
        todo.setCompleted(!todo.isCompleted());
        repository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}


