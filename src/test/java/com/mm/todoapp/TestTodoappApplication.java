package com.mm.todoapp;

import org.springframework.boot.SpringApplication;

public class TestTodoappApplication {

	public static void main(String[] args) {
		SpringApplication.from(TodoappApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
