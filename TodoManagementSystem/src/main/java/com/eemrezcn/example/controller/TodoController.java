package com.eemrezcn.example.controller;

import com.eemrezcn.example.dto.TodoDto;
import com.eemrezcn.example.entity.Todo;
import com.eemrezcn.example.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // allow to access from localhost:3000
@RestController // create RESTful web services
@RequestMapping("api/todos") // map web requests onto specific handler classes and/or handler methods
@AllArgsConstructor // create constructor with all arguments
public class TodoController {

    private TodoService todoService; // inject TodoService

    // Build Add Todo REST API

    @PreAuthorize("hasRole('ADMIN')") // only admin can add todo
    @PostMapping // http://localhost:8080/api/todos
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')") // admin and user can get todo
    @GetMapping("{id}") // http://localhost:8080/api/todos/{id}
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build Get All Todos REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')") // admin and user can get all todos
    @GetMapping // http://localhost:8080/api/todos
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos = todoService.getAllTodos();
        //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    // Build Update Todo REST API
    @PreAuthorize("hasRole('ADMIN')") // only admin can update todo
    @PutMapping("{id}") // http://localhost:8080/api/todos/{id}
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    // Build Delete Todo REST API
    @PreAuthorize("hasRole('ADMIN')") // only admin can delete todo
    @DeleteMapping("{id}") // http://localhost:8080/api/todos/{id}
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }

    // Build Complete Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')") // admin and user can complete todo
    @PatchMapping("{id}/complete") // http://localhost:8080/api/todos/{id}/complete
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    // Build In Complete Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')") // admin and user can incomplete todo
    @PatchMapping("{id}/in-complete") // http://localhost:8080/api/todos/{id}/in-complete
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

}