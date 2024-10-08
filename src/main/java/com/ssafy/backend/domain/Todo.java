package com.ssafy.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Todo {
    @Id
    private Long id;
    private String content;
    private boolean completed = false;
}
