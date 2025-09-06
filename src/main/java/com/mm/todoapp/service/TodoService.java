package com.mm.todoapp.service;

import com.mm.todoapp.model.Todo;
import com.mm.todoapp.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Todo createTodo(Todo newTodo) {
        newTodo.setCreatedAt(LocalDateTime.now());

        repository.save(newTodo);
        return newTodo;
    }

    public List<Todo> readAllTodos() {
        return repository.findAll();
    }

    public Todo readTodoById(UUID todoId) {
        return repository.findById(todoId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Todo updateTodo(UUID todoId, Todo newTodo) {
        Todo todo = repository.findById(todoId)
                .orElseThrow(EntityNotFoundException::new);

        todo.setTitle(newTodo.getTitle());
        todo.setDescription(newTodo.getDescription());
        todo.setDone(newTodo.isDone());
        if (todo.isDone()) {
            todo.setDoneAt(LocalDateTime.now());
        }

        repository.save(todo);
        return todo;
    }

    public void deleteTodo(UUID todoId) {
        repository.deleteById(todoId);
    }
}
