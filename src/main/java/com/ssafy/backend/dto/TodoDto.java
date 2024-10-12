package com.ssafy.backend.dto;

import com.ssafy.backend.domain.Todo;
import lombok.Getter;

@Getter
public class TodoDto {
    private Long id;
    private String content;
    private boolean completed;

    private TodoDto(Long id, String content, boolean completed){
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public static TodoDto fromEntity(Todo todo){
        return new TodoDto(todo.getId(), todo.getContent(), todo.isCompleted());
    }
}
