package com.mm.todoapp.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTodoRequest {

    private String title;
    private String description;
    private boolean done;
}
