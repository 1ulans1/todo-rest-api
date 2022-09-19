package com.todos.todos.service;

import com.todos.todos.dto.TodoDTO;
import com.todos.todos.models.entity.TodoEntity;
import com.todos.todos.models.entity.TodoStatus;
import com.todos.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoService(@Validated TodoRepository repository) {
        this.repository = repository;
    }

    public Optional<TodoEntity> getTodo(Long id) {
        return repository.findById(id);
    }

    public List<TodoEntity> getTodos() {
        return repository.findAll();
    }

    public TodoEntity addTodo(TodoDTO todoDTO) {
        return repository.save(TodoDTO.toEntity(todoDTO));
    }

    public Optional<TodoEntity> deleteTodo(Long id) {
        return Optional.empty();
    }

    public TodoEntity update(Long id, TodoDTO todo) {
        final TodoEntity todoToUpdate = repository.getReferenceById(id);

        if (todo.getStatus() != null) {
            todoToUpdate.setStatus(todo.getStatus());
        }

        if (todo.getStatus() != null) {
//            TodoStatus newStatus = todo.getStatus();
//            TodoStatus oldStatus = todoToUpdate.getStatus();
            todoToUpdate.setStatus(todo.getStatus());
        }

        if (todo.getDescribe() != null) {
            todoToUpdate.setDescribe(todo.getDescribe());
        }

        if (todo.getData() != null) {
            todoToUpdate.setData(todo.getData());
        }

        return repository.save(todoToUpdate);
    }

    public void update(Long id, TodoStatus status) {
        TodoEntity todoToUpdate = repository.getReferenceById(id);
        todoToUpdate.setStatus(status);
        repository.save(todoToUpdate);
    }
}

