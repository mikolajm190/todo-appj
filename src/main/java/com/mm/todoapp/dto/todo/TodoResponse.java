package com.mm.todoapp.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TodoResponse {

    private UUID id;
    private String title;
    private String description;
    private boolean done;
}
