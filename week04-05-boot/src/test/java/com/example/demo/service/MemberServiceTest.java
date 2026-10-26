package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    @DisplayName("회원 가입 성공")
    void joinSuccess() {
        // Given
        Member member = new Member("홍길동");
        Member saved = new Member("홍길동");
        ReflectionTestUtils.setField(saved, "id", 1L); // id는 setter가 없어서 강제로 넣음

        given(memberRepository.findByName("홍길동")).willReturn(Optional.empty());
        given(memberRepository.save(any(Member.class))).willReturn(saved);

        // When
        Long savedId = memberService.join(member);

        // Then
        assertThat(savedId).isEqualTo(1L);
    }

    @Test
    @DisplayName("중복 이름이면 예외")
    void duplicateName() {
        // Given
        given(memberRepository.findByName("홍길동"))
                .willReturn(Optional.of(new Member("홍길동")));

        // When & Then
        assertThatThrownBy(() -> memberService.join(new Member("홍길동")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 존재하는 회원입니다.");

        verify(memberRepository, never()).save(any());
    }
}