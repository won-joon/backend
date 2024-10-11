package com.ssafy.backend.dto.request;


import lombok.Getter;

@Getter
public class TodoRequest {
    private String content;

    public TodoRequest(String content){
        this.content = content;
    }
}
