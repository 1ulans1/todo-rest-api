package com.todos.todos.controller;

import com.todos.todos.dto.TodoDTO;
import com.todos.todos.entity.TodoEntity;
import com.todos.todos.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {

    private final Logger log = LoggerFactory.getLogger(TodoController.class);

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todo) {
        service.addTodo(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable Long id) {
        Optional<TodoEntity> todoEntity = service.getTodo(id);
        if (todoEntity.isPresent()) {
            return ResponseEntity.ok(TodoEntity.toDTO(todoEntity.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<TodoDTO>> getTodos() {
        Collection<TodoEntity> entities = service.getTodos();
        Collection<TodoDTO> todos = entities.stream().map(TodoEntity::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoDTO> deleteTodo(@PathVariable Long id) {

        Optional<TodoEntity> todoEntity = service.deleteTodo(id);
        if (todoEntity.isPresent()) {
            return ResponseEntity.ok(TodoEntity.toDTO(todoEntity.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDTO> updateDTO(@PathVariable Long id, TodoDTO todo) {
        return ResponseEntity.ok(service.update(id, todo));
    }
}

