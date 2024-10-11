package com.ssafy.backend.service;

import com.ssafy.backend.domain.Todo;
import com.ssafy.backend.dto.TodoDto;
import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.dto.request.TodoRequest;
import com.ssafy.backend.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public TodosDto getTodos() {
        return new TodosDto(todoRepository.findAll().stream().map(TodoDto::fromEntity).toList());
    }

    @Override
    public Long addTodo(TodoRequest request) {
        return todoRepository.save(Todo.from(request)).getId();
    }

    @Override
    public void updateTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
