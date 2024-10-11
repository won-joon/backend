package com.ssafy.backend.util;

import com.ssafy.backend.domain.Todo;
import com.ssafy.backend.dto.request.TodoRequest;
import com.ssafy.backend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TodoRepository todoRepository;
    private final Faker faker = new Faker(new Locale("ko", "ko"), new Random(42));

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        List<Todo> todoList = new ArrayList<>();
        for(int i=0; i<100000; i++){
            Todo todo = Todo.from(new TodoRequest(faker.lorem().sentence())); // 더미 할 일 생성
            todoList.add(todo);

            if(todoList.size() % 10000 == 0){
                todoRepository.saveAll(todoList);
                todoList.clear();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("데이터 생성 완료 시간 : " + (end - start) + " ms");
    }

}
