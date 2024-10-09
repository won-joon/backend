package com.ssafy.backend.domain;

import com.ssafy.backend.dto.request.TodoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean completed = false;

    private Todo(String content){
        this.content = content;
    }

    public static Todo from(TodoRequest request){
        return new Todo(request.getContent());
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
