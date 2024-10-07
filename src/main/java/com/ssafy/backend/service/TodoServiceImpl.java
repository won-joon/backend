package com.ssafy.backend.service;

import com.ssafy.backend.dto.TodoDto;
import com.ssafy.backend.dto.TodosDto;
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
}
