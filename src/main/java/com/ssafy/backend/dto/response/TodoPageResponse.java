package com.ssafy.backend.dto.response;

import com.ssafy.backend.dto.TodoDto;
import lombok.Getter;

import java.util.List;

@Getter
public class TodoPageResponse {
    private int currentPageNumber;
    private int size;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;
    private List<TodoDto> todos;

    private TodoPageResponse(int currentPageNumber, int size, int totalPage, boolean hasNext, boolean hasPrevious, List<TodoDto> todos){
        this.currentPageNumber = currentPageNumber;
        this.size = size;
        this.totalPage = totalPage;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
        this.todos = todos;
    }
    public static TodoPageResponse of(int currentPageNumber, int size, int totalPage, boolean hasNext, boolean hasPrevious, List<TodoDto> todos){
        return new TodoPageResponse(currentPageNumber, size, totalPage, hasNext, hasPrevious, todos);
    }


}
