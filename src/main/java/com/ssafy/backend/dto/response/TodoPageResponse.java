package com.ssafy.backend.dto.response;

import com.ssafy.backend.dto.TodoDto;
import lombok.Getter;

import java.util.List;

@Getter
public class TodoPageResponse {
    private int currentPageNumber;
    private int size;
    private boolean hasNext;
    private List<TodoDto> todos;

    private TodoPageResponse(int currentPageNumber, int size, boolean hasNext, List<TodoDto> todos){
        this.currentPageNumber = currentPageNumber;
        this.size = size;
        this.hasNext = hasNext;
        this.todos = todos;
    }
    public static TodoPageResponse of(int currentPageNumber, int size, boolean hasNext, List<TodoDto> todos){
        return new TodoPageResponse(currentPageNumber, size, hasNext, todos);
    }


}
