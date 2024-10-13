package com.ssafy.backend.service;

import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.dto.request.TodoRequest;
import com.ssafy.backend.dto.response.TodoCursorResponse;
import com.ssafy.backend.dto.response.TodoPageResponse;

public interface TodoService {
    TodosDto getTodos();
    Long addTodo(TodoRequest request);
    void updateTodo(Long todoId);

    void deleteTodo(Long todoId);

    TodoPageResponse getTodoPage(int page, int size);

    TodoCursorResponse getTodoCursor(Long cursorId, int size);
}
