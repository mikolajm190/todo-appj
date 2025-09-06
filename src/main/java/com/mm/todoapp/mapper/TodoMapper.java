package com.mm.todoapp.mapper;

import com.mm.todoapp.dto.todo.CreateTodoRequest;
import com.mm.todoapp.dto.todo.TodoResponse;
import com.mm.todoapp.dto.todo.UpdateTodoRequest;
import com.mm.todoapp.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoResponse toDto(Todo todo) {
        if (null == todo) {
            return null;
        }

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isDone()
        );
    }

    public Todo toEntity(CreateTodoRequest dto) {
        if (null == dto) {
            return null;
        }

        return Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }

    public Todo toEntity(UpdateTodoRequest dto) {
        if (null == dto) {
            return null;
        }

        return Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .done(dto.isDone())
                .build();
    }
}
