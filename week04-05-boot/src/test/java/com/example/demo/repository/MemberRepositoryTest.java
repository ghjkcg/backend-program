package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest // JPA 관련 설정만 로드
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 저장")
    void saveMember() {
        // Given
        Member member = new Member("SpringUser");
        // When
        Member savedMember = memberRepository.save(member);
        // Then
        assertThat(savedMember.getId()).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("SpringUser");
    }

    @Test
    @DisplayName("ID로 조회")
    void findById() {
        Member saved = memberRepository.save(new Member("홍길동"));

        Optional<Member> found = memberRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("이름으로 조회 (쿼리 메서드)")
    void findByName() {
        memberRepository.save(new Member("김철수"));

        Optional<Member> found = memberRepository.findByName("김철수");

        assertThat(found).isPresent();
    }

    @Test
    @DisplayName("없는 이름으로 조회하면 빈 Optional")
    void findByNameNotFound() {
        assertThat(memberRepository.findByName("없는사람")).isEmpty();
    }

    @Test
    @DisplayName("이름이 null이면 저장 실패 (nullable = false)")
    void saveNullName() {
        assertThatThrownBy(() -> memberRepository.saveAndFlush(new Member(null)))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
