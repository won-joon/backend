package com.ssafy.backend.repository;

import com.ssafy.backend.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(value = "SELECT * FROM todo t WHERE (:cursorId = 0 OR t.id > :cursorId) ORDER BY t.id ASC LIMIT :size", nativeQuery = true)
    List<Todo> findTodosByCursor(@Param("cursorId") Long cursorId, @Param("size") int size);
}
