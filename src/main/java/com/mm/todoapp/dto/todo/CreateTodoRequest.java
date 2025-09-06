package com.mm.todoapp.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTodoRequest {

    private String title;
    private String description;
}
