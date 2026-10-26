package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // save(), findById(), findAll(), delete() 자동 포함

    // 쿼리 메서드: SELECT * FROM member WHERE name = ?
    Optional<Member> findByName(String name);
}
