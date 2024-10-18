package com.ssafy.backend.service;

import com.ssafy.backend.domain.Todo;
import com.ssafy.backend.dto.TodoDto;
import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.dto.request.TodoRequest;
import com.ssafy.backend.dto.response.TodoCursorResponse;
import com.ssafy.backend.dto.response.TodoPageResponse;
import com.ssafy.backend.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public TodoPageResponse getTodoPage(int page, int size) {

        Page<Todo> todoPage = todoRepository.findAll(PageRequest.of(page, size));
        List<TodoDto> todoDtoList = todoPage.getContent().stream().map(TodoDto::fromEntity).toList();


        return TodoPageResponse.of(page, size, todoPage.getTotalPages(), todoPage.hasNext(), todoPage.hasPrevious(), todoDtoList);
    }

    @Override
    public TodoCursorResponse getTodoCursor(Long cursorId, int size) {
        List<Todo> todoList = todoRepository.findTodosByCursor(cursorId, size);

        List<TodoDto> todoDtoList = todoList.stream().map(TodoDto::fromEntity).toList();
        Long lastId = todoList.get(todoList.size() - 1).getId();

        return TodoCursorResponse.of(lastId, size, hasNext(lastId), todoDtoList);
    }

    private Boolean hasNext(Long lastId){
        return todoRepository.existsByLastId(lastId);
    }

}
