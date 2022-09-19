package com.todos.todos.models.entity;

import com.todos.todos.dto.TodoDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String title;

    @Column(name = "_describe")
    private String describe;
    @NotNull
    private LocalDate data;
    @NotNull
    private TodoStatus status;

    public TodoEntity(String title, LocalDate data, String describe, TodoStatus status) {
        this.title = title;
        this.data = data;
        this.describe = describe;
        this.status = status;
    }

    public TodoEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoEntity todo = (TodoEntity) o;
        return Objects.equals(title, todo.title) && Objects.equals(data, todo.data) && Objects.equals(describe, todo.describe) && status == todo.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, data, describe, status);
    }

    public static TodoDTO toDTO(TodoEntity todoEntity) {
        return new TodoDTO(todoEntity.title, todoEntity.data, todoEntity.describe, todoEntity.status);
    }
}

