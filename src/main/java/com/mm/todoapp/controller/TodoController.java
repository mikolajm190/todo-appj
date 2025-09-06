package com.mm.todoapp.controller;

import com.mm.todoapp.dto.todo.CreateTodoRequest;
import com.mm.todoapp.dto.todo.TodoResponse;
import com.mm.todoapp.dto.todo.UpdateTodoRequest;
import com.mm.todoapp.mapper.TodoMapper;
import com.mm.todoapp.model.Todo;
import com.mm.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @Autowired
    private TodoMapper mapper;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody CreateTodoRequest request) {
        Todo todo = service.createTodo(mapper.toEntity(request));
        return ResponseEntity.ok(mapper.toDto(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        List<Todo> todos = service.readAllTodos();
        return ResponseEntity.ok(todos.stream().map(todo -> mapper.toDto(todo)).toList());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> readById(@PathVariable UUID todoId) {
        Todo todo = service.readTodoById(todoId);
        return ResponseEntity.ok(todo.toDto());
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponse> update(@PathVariable UUID todoId, @RequestBody UpdateTodoRequest request) {
        Todo todo = service.updateTodo(todoId, mapper.toEntity(request));
        return ResponseEntity.ok(mapper.toDto(todo));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> delete(@PathVariable UUID todoId) {
        service.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }
}
