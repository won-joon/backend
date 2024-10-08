package com.ssafy.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class TodosDto {
    private List<TodoDto> todos;

    public TodosDto(List<TodoDto> todos){
        this.todos = todos;
    }
}
