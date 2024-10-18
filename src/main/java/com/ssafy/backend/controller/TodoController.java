package com.ssafy.backend.controller;

import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.dto.request.TodoRequest;
import com.ssafy.backend.dto.response.TodoCursorResponse;
import com.ssafy.backend.dto.response.TodoPageResponse;
import com.ssafy.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<TodosDto> getTodos(){
        return ResponseEntity.ok().body(todoService.getTodos());
    }

    @PostMapping("/todos")
    public ResponseEntity<Void> addTodo(@RequestBody TodoRequest request){
        todoService.addTodo(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<Void> updateTodo(@PathVariable("todoId") Long todoId){
        todoService.updateTodo(todoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("todoId") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/offset")
    public ResponseEntity<TodoPageResponse> getTodoPage(@RequestParam("size") int size, @RequestParam("page") int page) {

        return ResponseEntity.ok(todoService.getTodoPage(page, size));
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<TodoCursorResponse> getTodoCursor(@RequestParam("size") int size, @RequestParam("cursorId") Long cursorId) {

        return ResponseEntity.ok(todoService.getTodoCursor(cursorId, size));
    }
}