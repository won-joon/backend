package com.ssafy.backend.service;

import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.dto.request.TodoRequest;

public interface TodoService {
    TodosDto getTodos();
    Long addTodo(TodoRequest request);
    void updateTodo(Long todoId);

    void deleteTodo(Long todoId);
}
