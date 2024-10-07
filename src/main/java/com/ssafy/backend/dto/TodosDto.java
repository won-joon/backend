package com.ssafy.backend.dto;

import lombok.Setter;

import java.util.List;

public class TodosDto {
    private List<TodoDto> todos;

    public TodosDto(List<TodoDto> todos){
        this.todos = todos;
    }
}
