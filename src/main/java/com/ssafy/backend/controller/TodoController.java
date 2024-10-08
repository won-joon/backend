package com.ssafy.backend.controller;

import com.ssafy.backend.dto.TodosDto;
import com.ssafy.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<TodosDto> getTodos(){
        return ResponseEntity.ok().body(todoService.getTodos());
    }
}
