package com.mm.todoapp.config;

import com.mm.todoapp.model.Todo;
import com.mm.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        Set<Todo> todos = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            todos.add(new Todo(null, "title " + i, "desc " + i, false, LocalDateTime.now(), null));
        }
        return args -> {
            repository.deleteAll();
            repository.saveAll(todos);
        };
    }
}
