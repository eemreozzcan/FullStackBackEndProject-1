package com.eemrezcn.example.service.impl;

import com.eemrezcn.example.dto.TodoDto;
import com.eemrezcn.example.entity.Todo;
import com.eemrezcn.example.exception.ResourceNotFoundException;
import com.eemrezcn.example.repository.TodoRepository;
import com.eemrezcn.example.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {


    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    // This method is used to add a new Todo
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // convert TodoDto into Todo Jpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo Jpa entity object into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }

    // This method is used to get a Todo by id
    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));

        return modelMapper.map(todo, TodoDto.class);
    }

    // This method is used to get all Todos
    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    //This method is used to update a Todo
    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {

        //check if Todo exists in database
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        //save updated Todo
        Todo updatedTodo = todoRepository.save(todo);

        //convert updated Todo into TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {

        //check if Todo exists in database
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        //delete Todo
        todoRepository.deleteById(id);
    }

    // This method is used to complete a Todo
    @Override
    public TodoDto completeTodo(Long id) {

        //check if Todo exists in database
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        //set Todo as completed
        todo.setCompleted(Boolean.TRUE);

        //save updated Todo
        Todo updatedTodo = todoRepository.save(todo);

        //convert updated Todo into TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    // This method is used to incomplete a Todo
    @Override
    public TodoDto inCompleteTodo(Long id) {

        //check if Todo exists in database
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        //set Todo as incomplete
        todo.setCompleted(Boolean.FALSE);

        //save updated Todo
        Todo updatedTodo = todoRepository.save(todo);

        //convert updated Todo into TodoDto
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}