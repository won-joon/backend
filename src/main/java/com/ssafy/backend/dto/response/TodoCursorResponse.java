package com.ssafy.backend.dto.response;

import com.ssafy.backend.dto.TodoDto;
import lombok.Getter;

import java.util.List;

@Getter
public class TodoCursorResponse {
    private Long lastId;
    private int size;
    private boolean hasNext;
    private List<TodoDto> todos;

    private TodoCursorResponse(Long lastId, int size, boolean hasNext, List<TodoDto> todos){
        this.lastId = lastId;
        this.size = size;
        this.hasNext = hasNext;
        this.todos = todos;
    }
    public static TodoCursorResponse of(Long lastId, int size, boolean hasNext, List<TodoDto> todos){
        return new TodoCursorResponse(lastId, size, hasNext, todos);
    }

}
