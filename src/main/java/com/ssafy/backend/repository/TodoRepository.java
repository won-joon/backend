package com.ssafy.backend.repository;

import com.ssafy.backend.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t WHERE t.id > :cursorId ORDER BY t.id ASC LIMIT :size")
    List<Todo> findTodosByCursor(@Param("cursorId") Long cursorId, @Param("size") int size);

    @Query(value = "SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Todo t WHERE t.id > :lastId")
    Boolean existsByLastId(@Param("lastId") Long lastId);
}
