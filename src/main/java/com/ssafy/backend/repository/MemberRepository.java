package com.ssafy.backend.repository;

import com.ssafy.backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByAccessToken(String accessToken);

    @Query("SELECT m.nickname FROM Member m WHERE m.accessToken = :accessToken")
    Optional<String> findNicknameByAccessToken(@Param("accessToken") String accessToken);

    Member findByRefreshToken(String refreshToken);
}
