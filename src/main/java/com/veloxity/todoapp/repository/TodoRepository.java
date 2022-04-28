package com.veloxity.todoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.veloxity.todoapp.entity.TodoItem;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {
	List<TodoItem> findAll();
}
