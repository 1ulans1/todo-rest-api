package com.todos.todos.dto;

import com.todos.todos.entity.TodoEntity;
import com.todos.todos.entity.TodoStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class TodoDTO {
    @NotNull
    private String title;
    private String describe;
    @NotNull
    private LocalDate data;
    @NotNull
    private TodoStatus status;

    public TodoDTO() {
    }

    public TodoDTO(String title, LocalDate data, String describe, TodoStatus status) {
        this.title = title;
        this.data = data;
        this.describe = describe;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoDTO todoDTO = (TodoDTO) o;
        return Objects.equals(title, todoDTO.title) && Objects.equals(data, todoDTO.data) && Objects.equals(describe, todoDTO.describe) && Objects.equals(status, todoDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, data, describe, status);
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

    public static TodoEntity toEntity(TodoDTO todoEntity) {
        return new TodoEntity(todoEntity.title, todoEntity.data, todoEntity.describe, todoEntity.status);
    }
}

