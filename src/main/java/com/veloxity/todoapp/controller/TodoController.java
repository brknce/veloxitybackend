package com.veloxity.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veloxity.todoapp.entity.TodoItem;
import com.veloxity.todoapp.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("api/todoItems")
	public ResponseEntity<?> getAllTodoItems() {
		List<TodoItem> todoItems = todoService.getAllTodoItems();
		return ResponseEntity.ok(todoItems);
	}

	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createNewTodoItem() {
		TodoItem todoItem = todoService.createTodoItem();
		return ResponseEntity.ok(todoItem);
	}

	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
		TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);
		return ResponseEntity.ok(updatedTodoItem);
	}
	
	@DeleteMapping("/api/todoItems/{id}")
	public ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
		todoService.deleteTodoItem(id);
		return ResponseEntity.ok("ok");
	}
}
